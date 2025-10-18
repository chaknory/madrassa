import { Injectable, signal } from '@angular/core';
import { BehaviorSubject, Observable, shareReplay, tap } from 'rxjs';
import { EleveService } from './eleve.service';
import { ClasseService } from './classe.service';
import { NoteService } from './note.service';
import { AnneeScolaireService } from './annee-scolaire.service';

export interface DashboardData {
  eleves: any[];
  classes: any[];
  notes: any[];
  anneeActive: any | null;
  lastUpdate: Date;
}

@Injectable({
  providedIn: 'root'
})
export class StateService {
  private readonly CACHE_DURATION = 5 * 60 * 1000; // 5 minutes
  
  // État global avec signaux
  private _dashboardData = signal<DashboardData | null>(null);
  private _isLoading = signal(false);
  private _lastUpdate = signal<Date | null>(null);

  // Observables partagés pour éviter les requêtes multiples
  private dashboardCache$: Observable<DashboardData> | null = null;

  constructor(
    private eleveService: EleveService,
    private classeService: ClasseService,
    private noteService: NoteService,
    private anneeScolaireService: AnneeScolaireService
  ) {}

  // Getter pour les signaux
  get dashboardData() { return this._dashboardData.asReadonly(); }
  get isLoading() { return this._isLoading.asReadonly(); }
  get lastUpdate() { return this._lastUpdate.asReadonly(); }

  /**
   * Charge les données du dashboard une seule fois et les met en cache
   */
  loadDashboardData(forceRefresh = false): Observable<DashboardData> {
    const now = new Date();
    const lastUpdate = this._lastUpdate();
    
    // Vérifier si on a besoin de recharger les données
    const needsRefresh = forceRefresh || 
                        !this.dashboardCache$ || 
                        !lastUpdate || 
                        (now.getTime() - lastUpdate.getTime()) > this.CACHE_DURATION;

    if (!needsRefresh && this.dashboardCache$) {
      return this.dashboardCache$;
    }

    console.log('🔄 Chargement des données du dashboard...');
    this._isLoading.set(true);

    // Créer un nouvel observable partagé
    this.dashboardCache$ = new Observable<DashboardData>(observer => {
      Promise.all([
        this.eleveService.getEleves().toPromise(),
        this.classeService.getClasses().toPromise(),
        this.noteService.getNotes().toPromise(),
        this.anneeScolaireService.getAnneeActive().toPromise()
      ]).then(([eleves, classes, notes, anneeActive]) => {
        // Traiter les réponses paginées
        const elevesData = Array.isArray(eleves) ? eleves : eleves?.content || [];
        const classesData = Array.isArray(classes) ? classes : classes?.content || [];
        const notesData = Array.isArray(notes) ? notes : notes?.content || [];

        const data: DashboardData = {
          eleves: elevesData,
          classes: classesData,
          notes: notesData,
          anneeActive: anneeActive || null,
          lastUpdate: new Date()
        };

        // Mettre à jour l'état
        this._dashboardData.set(data);
        this._lastUpdate.set(new Date());
        this._isLoading.set(false);

        observer.next(data);
        observer.complete();

        console.log('✅ Données du dashboard chargées:', {
          eleves: elevesData.length,
          classes: classesData.length,
          notes: notesData.length,
          anneeActive: anneeActive?.libelle || 'Aucune'
        });

      }).catch(error => {
        console.error('❌ Erreur lors du chargement des données:', error);
        this._isLoading.set(false);
        observer.error(error);
      });
    }).pipe(
      shareReplay(1) // Partager la même requête entre tous les abonnés
    );

    return this.dashboardCache$;
  }

  /**
   * Force le rechargement des données
   */
  refreshDashboardData(): Observable<DashboardData> {
    this.clearCache();
    return this.loadDashboardData(true);
  }

  /**
   * Vide le cache
   */
  clearCache(): void {
    this.dashboardCache$ = null;
    this._dashboardData.set(null);
    this._lastUpdate.set(null);
    console.log('🗑️ Cache vidé');
  }

  /**
   * Vérifie si les données sont fraîches
   */
  isCacheFresh(): boolean {
    const lastUpdate = this._lastUpdate();
    if (!lastUpdate) return false;
    
    const now = new Date();
    return (now.getTime() - lastUpdate.getTime()) < this.CACHE_DURATION;
  }
}