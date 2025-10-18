import { Component, signal, inject, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { EleveService } from '../../services/eleve.service';
import { ClasseService } from '../../services/classe.service';
import { NoteService } from '../../services/note.service';
import { AnneeScolaireService } from '../../services/annee-scolaire.service';
import { forkJoin, Subscription } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterLink],
  template: `
    <div class="dashboard-container">
      <h1>🎓 Tableau de Bord - Madrassa</h1>
      
      <!-- Année Scolaire Active -->
      @if (anneeActive()) {
        <div class="active-year-card">
          <h2>📅 Année Scolaire Active</h2>
          <div class="year-info">
            <h3>{{ anneeActive()?.libelle }}</h3>
            <p>{{ formatDate(anneeActive()?.dateDebut) }} - {{ formatDate(anneeActive()?.dateFin) }}</p>
          </div>
        </div>
      }

      <!-- Statistiques Principales -->
      <div class="stats-grid">
        <div class="stat-card eleves">
          <div class="stat-icon">👥</div>
          <div class="stat-content">
            <h3>Élèves</h3>
            <div class="stat-number">{{ totalEleves() }}</div>
            <p>élèves inscrits</p>
          </div>
        </div>

        <div class="stat-card classes">
          <div class="stat-icon">🏫</div>
          <div class="stat-content">
            <h3>Classes</h3>
            <div class="stat-number">{{ totalClasses() }}</div>
            <p>classes actives</p>
          </div>
        </div>

        <div class="stat-card notes">
          <div class="stat-icon">📝</div>
          <div class="stat-content">
            <h3>Notes</h3>
            <div class="stat-number">{{ totalNotes() }}</div>
            <p>notes saisies</p>
          </div>
        </div>

        <div class="stat-card moyenne">
          <div class="stat-icon">📊</div>
          <div class="stat-content">
            <h3>Moyenne</h3>
            <div class="stat-number">{{ moyenneGenerale() }}</div>
            <p>moyenne générale</p>
          </div>
        </div>
      </div>

      <!-- Actions Rapides -->
      <div class="quick-actions">
        <h2>🚀 Actions Rapides</h2>
        <div class="actions-grid">
          <a routerLink="/eleves" class="action-card">
            <div class="action-icon">👨‍🎓</div>
            <h3>Gestion des Élèves</h3>
            <p>Ajouter, modifier ou consulter les élèves</p>
          </a>

          <a routerLink="/annees-scolaires" class="action-card">
            <div class="action-icon">📅</div>
            <h3>Années Scolaires</h3>
            <p>Gérer les années scolaires et périodes</p>
          </a>

          <div class="action-card" (click)="refreshData()">
            <div class="action-icon">🔄</div>
            <h3>Actualiser</h3>
            <p>Rafraîchir les données du tableau de bord</p>
          </div>

          <div class="action-card">
            <div class="action-icon">📈</div>
            <h3>Rapports</h3>
            <p>Générer des rapports et statistiques</p>
          </div>
        </div>
      </div>

      <!-- État de chargement -->
      @if (isLoading()) {
        <div class="loading-overlay">
          <div class="loading-spinner"></div>
          <p>Chargement des données...</p>
        </div>
      }

      <!-- Message d'erreur -->
      @if (errorMessage()) {
        <div class="error-message">
          <p>❌ {{ errorMessage() }}</p>
          <button (click)="refreshData()" class="retry-btn">Réessayer</button>
        </div>
      }
    </div>
  `,
  styles: [`
    .dashboard-container {
      max-width: 1200px;
      margin: 0 auto;
      padding: 20px;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    h1 {
      text-align: center;
      color: #2c3e50;
      margin-bottom: 30px;
      font-size: 2.5rem;
    }

    .active-year-card {
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      color: white;
      padding: 20px;
      border-radius: 15px;
      margin-bottom: 30px;
      text-align: center;
      box-shadow: 0 8px 32px rgba(102, 126, 234, 0.3);
    }

    .active-year-card h2 {
      margin: 0 0 15px 0;
      font-size: 1.3rem;
    }

    .year-info h3 {
      margin: 0 0 10px 0;
      font-size: 1.8rem;
      font-weight: bold;
    }

    .year-info p {
      margin: 0;
      font-size: 1.1rem;
      opacity: 0.9;
    }

    .stats-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
      gap: 20px;
      margin-bottom: 40px;
    }

    .stat-card {
      background: white;
      padding: 25px;
      border-radius: 15px;
      box-shadow: 0 5px 20px rgba(0,0,0,0.1);
      display: flex;
      align-items: center;
      gap: 20px;
      transition: transform 0.3s ease, box-shadow 0.3s ease;
    }

    .stat-card:hover {
      transform: translateY(-5px);
      box-shadow: 0 10px 30px rgba(0,0,0,0.15);
    }

    .stat-icon {
      font-size: 3rem;
      width: 80px;
      height: 80px;
      display: flex;
      align-items: center;
      justify-content: center;
      border-radius: 50%;
      background: #f8f9fa;
    }

    .stat-card.eleves .stat-icon { background: linear-gradient(135deg, #667eea, #764ba2); }
    .stat-card.classes .stat-icon { background: linear-gradient(135deg, #f093fb, #f5576c); }
    .stat-card.notes .stat-icon { background: linear-gradient(135deg, #4facfe, #00f2fe); }
    .stat-card.moyenne .stat-icon { background: linear-gradient(135deg, #43e97b, #38f9d7); }

    .stat-content h3 {
      margin: 0 0 10px 0;
      color: #2c3e50;
      font-size: 1.1rem;
    }

    .stat-number {
      font-size: 2.5rem;
      font-weight: bold;
      color: #2c3e50;
      margin-bottom: 5px;
    }

    .stat-content p {
      margin: 0;
      color: #7f8c8d;
      font-size: 0.9rem;
    }

    .quick-actions {
      margin-bottom: 30px;
    }

    .quick-actions h2 {
      color: #2c3e50;
      margin-bottom: 20px;
      font-size: 1.8rem;
    }

    .actions-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
      gap: 20px;
    }

    .action-card {
      background: white;
      padding: 25px;
      border-radius: 15px;
      box-shadow: 0 5px 20px rgba(0,0,0,0.1);
      text-decoration: none;
      color: inherit;
      transition: all 0.3s ease;
      cursor: pointer;
      text-align: center;
    }

    .action-card:hover {
      transform: translateY(-5px);
      box-shadow: 0 10px 30px rgba(0,0,0,0.15);
      text-decoration: none;
      color: inherit;
    }

    .action-icon {
      font-size: 3rem;
      margin-bottom: 15px;
    }

    .action-card h3 {
      margin: 0 0 10px 0;
      color: #2c3e50;
      font-size: 1.3rem;
    }

    .action-card p {
      margin: 0;
      color: #7f8c8d;
      line-height: 1.5;
    }

    .loading-overlay {
      position: fixed;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      background: rgba(255, 255, 255, 0.9);
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      z-index: 1000;
    }

    .loading-spinner {
      width: 50px;
      height: 50px;
      border: 5px solid #ecf0f1;
      border-top: 5px solid #3498db;
      border-radius: 50%;
      animation: spin 1s linear infinite;
      margin-bottom: 20px;
    }

    @keyframes spin {
      0% { transform: rotate(0deg); }
      100% { transform: rotate(360deg); }
    }

    .error-message {
      background: #ffebee;
      color: #c62828;
      padding: 20px;
      border-radius: 10px;
      text-align: center;
      margin-top: 20px;
    }

    .retry-btn {
      background: #3498db;
      color: white;
      border: none;
      padding: 10px 20px;
      border-radius: 5px;
      cursor: pointer;
      margin-top: 10px;
    }

    .retry-btn:hover {
      background: #2980b9;
    }

    @media (max-width: 768px) {
      .dashboard-container {
        padding: 15px;
      }

      .stats-grid {
        grid-template-columns: 1fr;
      }

      .actions-grid {
        grid-template-columns: 1fr;
      }

      .stat-card {
        flex-direction: column;
        text-align: center;
        gap: 15px;
      }

      .stat-icon {
        width: 60px;
        height: 60px;
        font-size: 2rem;
      }
    }
  `]
})
export class DashboardComponent implements OnInit, OnDestroy {
  private eleveService = inject(EleveService);
  private classeService = inject(ClasseService);
  private noteService = inject(NoteService);
  private anneeScolaireService = inject(AnneeScolaireService);

  // Signaux pour les données
  totalEleves = signal(0);
  totalClasses = signal(0);
  totalNotes = signal(0);
  moyenneGenerale = signal('--');
  anneeActive = signal<any>(null);
  isLoading = signal(false);
  errorMessage = signal('');

  // Subscription pour gérer les observables
  private subscription = new Subscription();

  async ngOnInit() {
    await this.loadData();
  }

  ngOnDestroy() {
    // IMPORTANT: Se désabonner pour éviter les fuites mémoire
    this.subscription.unsubscribe();
  }

  async loadData() {
    this.isLoading.set(true);
    this.errorMessage.set('');

    try {
      // Utiliser forkJoin pour charger toutes les données en parallèle
      // et s'assurer qu'on ne fait qu'UNE seule requête
      const data$ = forkJoin({
        eleves: this.eleveService.getEleves().pipe(
          catchError(error => {
            console.error('Erreur élèves:', error);
            return of([]);
          })
        ),
        classes: this.classeService.getClasses().pipe(
          catchError(error => {
            console.error('Erreur classes:', error);
            return of([]);
          })
        ),
        notes: this.noteService.getNotes().pipe(
          catchError(error => {
            console.error('Erreur notes:', error);
            return of([]);
          })
        ),
        anneeActive: this.anneeScolaireService.getAnneeActive().pipe(
          catchError(error => {
            console.error('Erreur année active:', error);
            return of(null);
          })
        )
      });

      // S'abonner UNE SEULE FOIS aux données
      const subscription = data$.subscribe({
        next: (data) => {
          // Gérer les réponses paginées
          const elevesData = Array.isArray(data.eleves) ? data.eleves : data.eleves?.content || [];
          const classesData = Array.isArray(data.classes) ? data.classes : data.classes?.content || [];
          const notesData = Array.isArray(data.notes) ? data.notes : data.notes?.content || [];
          
          this.totalEleves.set(elevesData.length);
          this.totalClasses.set(classesData.length);
          this.totalNotes.set(notesData.length);
          this.anneeActive.set(data.anneeActive);
          
          // Calculer la moyenne générale
          if (notesData.length > 0) {
            const somme = notesData.reduce((acc: number, note: any) => acc + (note.valeur || 0), 0);
            const moyenne = (somme / notesData.length).toFixed(1);
            this.moyenneGenerale.set(moyenne);
          } else {
            this.moyenneGenerale.set('--');
          }
          
          this.isLoading.set(false);
        },
        error: (error) => {
          console.error('Erreur lors du chargement des données:', error);
          this.errorMessage.set('Erreur lors du chargement des données');
          this.isLoading.set(false);
        }
      });

      // Ajouter la subscription au gestionnaire
      this.subscription.add(subscription);

    } catch (error) {
      console.error('Erreur lors du chargement des données:', error);
      this.errorMessage.set('Erreur lors du chargement des données');
      this.isLoading.set(false);
    }
  }

  async refreshData() {
    await this.loadData();
  }

  formatDate(dateStr: string | undefined): string {
    if (!dateStr) return '';
    const date = new Date(dateStr);
    return date.toLocaleDateString('fr-FR', {
      day: '2-digit',
      month: '2-digit',
      year: 'numeric'
    });
  }
}