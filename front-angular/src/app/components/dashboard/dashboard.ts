import { Component, OnInit, OnDestroy, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Subject, takeUntil, forkJoin, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { EleveService } from '../../services/eleve.service';
import { ClasseService } from '../../services/classe.service';
import { NoteService } from '../../services/note.service';
import { TranslatePipe } from '../../pipes/translate.pipe';
import { LanguageSelectorComponent } from '../language-selector/language-selector';
import { AnneeScolaireService } from '../../services/annee-scolaire.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterModule, TranslatePipe, LanguageSelectorComponent],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class DashboardComponent implements OnInit, OnDestroy {
  private eleveService = inject(EleveService);
  private classeService = inject(ClasseService);
  private noteService = inject(NoteService);
  private anneeScolaireService = inject(AnneeScolaireService);
  private destroy$ = new Subject<void>();

  stats = {
    totalEleves: 0,
    totalClasses: 0,
    totalNotes: 0,
    anneeActive: ''
  };

  isLoading = true;

  ngOnInit() {
    this.loadDashboardData();
  }

  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }

  private loadDashboardData() {
    this.isLoading = true;
    
    // Utiliser forkJoin pour faire les appels en parallèle avec une gestion d'erreur robuste
    forkJoin({
      eleves: this.eleveService.getAllEleves().pipe(
        catchError(error => {
          console.error('Erreur lors du chargement des élèves:', error);
          return of([]);
        })
      ),
      classes: this.classeService.getClasses(0, 1).pipe(
        catchError(error => {
          console.error('Erreur lors du chargement des classes:', error);
          return of({ totalElements: 0 } as any);
        })
      ),
      notes: this.noteService.getNotes(0, 1).pipe(
        catchError(error => {
          console.error('Erreur lors du chargement des notes:', error);
          return of({ totalElements: 0 } as any);
        })
      ),
      anneeActive: this.anneeScolaireService.getAnneeActive().pipe(
        catchError(error => {
          console.log('Aucune année active trouvée ou erreur API:', error);
          return of({ libelle: 'Non définie' } as any);
        })
      )
    }).pipe(
      takeUntil(this.destroy$)
    ).subscribe({
      next: (results) => {
        this.stats = {
          totalEleves: results.eleves?.length || 0,
          totalClasses: results.classes?.totalElements || 0,
          totalNotes: results.notes?.totalElements || 0,
          anneeActive: results.anneeActive?.libelle || 'Non définie'
        };
        this.isLoading = false;
      },
      error: (error) => {
        console.error('Erreur lors du chargement des données:', error);
        this.stats = {
          totalEleves: 0,
          totalClasses: 0,
          totalNotes: 0,
          anneeActive: 'Erreur de connexion'
        };
        this.isLoading = false;
      }
    });
  }
}
