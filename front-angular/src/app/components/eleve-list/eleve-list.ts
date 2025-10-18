import { Component, OnInit, OnDestroy, inject, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Subject, takeUntil } from 'rxjs';
import { EleveService } from '../../services/eleve.service';
import { Eleve } from '../../models/eleve.model';
import { PaginatedResponse } from '../../models/api.model';
import { TranslatePipe } from '../../pipes/translate.pipe';

interface EleveAffichage extends Eleve {
  ageCalcule?: number;
  dateFormatee?: string;
}

@Component({
  selector: 'app-eleve-list',
  standalone: true,
  imports: [CommonModule, FormsModule, TranslatePipe],
  templateUrl: './eleve-list.html',
  styleUrl: './eleve-list.css',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EleveListComponent implements OnInit, OnDestroy {
  private eleveService = inject(EleveService);
  private cdr = inject(ChangeDetectorRef);
  private destroy$ = new Subject<void>();

  eleves: EleveAffichage[] = [];
  isLoading = true;
  searchQuery = '';
  
  // Pagination
  currentPage = 0;
  pageSize = 10;
  totalPages = 0;
  totalElements = 0;

  ngOnInit() {
    this.loadEleves();
  }

  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }

  loadEleves() {
    console.log('🔄 Frontend: Début du chargement des élèves');
    this.isLoading = true;
    if (this.searchQuery.trim()) {
      this.searchEleves();
    } else {
      const startTime = performance.now();
      this.eleveService.getAllEleves()
        .pipe(takeUntil(this.destroy$))
        .subscribe({
          next: (eleves: Eleve[]) => {
            const endTime = performance.now();
            console.log(`✅ Frontend: Données reçues en ${endTime - startTime}ms`);
            
            // Pré-calculer les valeurs pour optimiser le rendu
            this.eleves = eleves.map(eleve => ({
              ...eleve,
              ageCalcule: this.calculateAge(eleve.dateNaissance),
              dateFormatee: this.formatDateOnce(eleve.dateNaissance)
            }));
            
            this.totalElements = eleves.length;
            this.totalPages = 1;
            this.isLoading = false;
            
            this.cdr.detectChanges();
            console.log('✅ Frontend: Rendu terminé');
          },
          error: (error) => {
            console.error('Erreur lors du chargement des élèves:', error);
            this.isLoading = false;
            this.cdr.detectChanges();
          }
        });
    }
  }

  searchEleves() {
    console.log('🔍 Frontend: Début de la recherche');
    this.isLoading = true;
    
    this.eleveService.getAllEleves()
      .pipe(takeUntil(this.destroy$))
      .subscribe({
        next: (eleves: Eleve[]) => {
          // Filtrer les élèves selon la recherche
          const filtered = eleves.filter(eleve => 
            eleve.nom.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
            eleve.prenom.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
            eleve.numeroEleve.toLowerCase().includes(this.searchQuery.toLowerCase())
          );
          
          // Pré-calculer les valeurs pour les élèves filtrés
          this.eleves = filtered.map(eleve => ({
            ...eleve,
            ageCalcule: this.calculateAge(eleve.dateNaissance),
            dateFormatee: this.formatDateOnce(eleve.dateNaissance)
          }));
          
          this.totalElements = filtered.length;
          this.totalPages = 1;
          this.isLoading = false;
          
          this.cdr.detectChanges();
          console.log(`✅ Frontend: ${filtered.length} élèves trouvés`);
        },
        error: (error) => {
          console.error('Erreur lors de la recherche:', error);
          this.isLoading = false;
          this.cdr.detectChanges();
        }
      });
  }

  onSearch() {
    this.currentPage = 0;
    this.loadEleves();
  }

  clearSearch() {
    this.searchQuery = '';
    this.currentPage = 0;
    this.loadEleves();
  }

  goToPage(page: number) {
    if (page >= 0 && page < this.totalPages) {
      this.currentPage = page;
      this.loadEleves();
    }
  }

  deleteEleve(eleve: Eleve) {
    if (confirm(`Êtes-vous sûr de vouloir supprimer l'élève ${eleve.prenom} ${eleve.nom} ?`)) {
      this.eleveService.deleteEleve(eleve.id!)
        .pipe(takeUntil(this.destroy$))
        .subscribe({
          next: () => {
            this.loadEleves();
          },
          error: (error) => {
            console.error('Erreur lors de la suppression:', error);
            alert('Erreur lors de la suppression de l\'élève');
          }
        });
    }
  }

  formatDate(dateString: string): string {
    return new Date(dateString).toLocaleDateString('fr-FR');
  }

  formatDateOnce(dateString: string): string {
    return new Date(dateString).toLocaleDateString('fr-FR');
  }

  getAge(dateNaissance: string): number {
    const today = new Date();
    const birthDate = new Date(dateNaissance);
    let age = today.getFullYear() - birthDate.getFullYear();
    const monthDiff = today.getMonth() - birthDate.getMonth();
    
    if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    
    return age;
  }

  calculateAge(dateNaissance: string): number {
    const today = new Date();
    const birthDate = new Date(dateNaissance);
    let age = today.getFullYear() - birthDate.getFullYear();
    const monthDiff = today.getMonth() - birthDate.getMonth();
    
    if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    
    return age;
  }
}
