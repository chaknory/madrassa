import { Component, signal, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AnneeScolaireService } from '../../services/annee-scolaire.service';
import { AnneeScolaire } from '../../models/annee-scolaire';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-annee-scolaire',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="annee-scolaire-container">
      <h2>🎓 Gestion des Années Scolaires</h2>
      
      <!-- Année Active -->
      <div class="section active-year">
        <h3>Année Scolaire Active</h3>
        @if (anneeActive()) {
          <div class="year-card active">
            <div class="year-info">
              <h4>{{ anneeActive()?.libelle }}</h4>
              <p>{{ formatDate(anneeActive()?.dateDebut) }} - {{ formatDate(anneeActive()?.dateFin) }}</p>
              <span class="status active">ACTIVE</span>
            </div>
          </div>
        } @else {
          <div class="no-active-year">
            <p>⚠️ Aucune année scolaire active</p>
          </div>
        }
      </div>

      <!-- Liste de toutes les années -->
      <div class="section all-years">
        <div class="section-header">
          <h3>Toutes les Années Scolaires</h3>
          <button class="btn btn-primary" (click)="showCreateForm = !showCreateForm">
            {{ showCreateForm ? 'Annuler' : '+ Nouvelle Année' }}
          </button>
        </div>

        <!-- Formulaire de création -->
        @if (showCreateForm) {
          <div class="create-form">
            <div class="form-group">
              <label for="libelle">Libellé :</label>
              <input 
                type="text" 
                id="libelle" 
                [(ngModel)]="nouvelleAnnee.libelle" 
                placeholder="Ex: 2024-2025"
                class="form-control">
            </div>
            <div class="form-row">
              <div class="form-group">
                <label for="dateDebut">Date de début :</label>
                <input 
                  type="date" 
                  id="dateDebut" 
                  [(ngModel)]="nouvelleAnnee.dateDebut" 
                  class="form-control">
              </div>
              <div class="form-group">
                <label for="dateFin">Date de fin :</label>
                <input 
                  type="date" 
                  id="dateFin" 
                  [(ngModel)]="nouvelleAnnee.dateFin" 
                  class="form-control">
              </div>
            </div>
            <div class="form-actions">
              <button class="btn btn-success" (click)="creerAnnee()" [disabled]="isLoading()">
                {{ isLoading() ? 'Création...' : 'Créer' }}
              </button>
              <button class="btn btn-secondary" (click)="annulerCreation()">
                Annuler
              </button>
            </div>
          </div>
        }

        <!-- Liste des années -->
        <div class="years-list">
          @for (annee of anneesListe(); track annee.id) {
            <div class="year-card" [class.active]="annee.active">
              <div class="year-info">
                <h4>{{ annee.libelle }}</h4>
                <p>{{ formatDate(annee.dateDebut) }} - {{ formatDate(annee.dateFin) }}</p>
                <span class="status" [class.active]="annee.active">
                  {{ annee.active ? 'ACTIVE' : 'INACTIVE' }}
                </span>
              </div>
              <div class="year-actions">
                @if (!annee.active) {
                  <button 
                    class="btn btn-sm btn-outline-primary" 
                    (click)="activerAnnee(annee.id!)"
                    [disabled]="isLoading()">
                    Activer
                  </button>
                }
                <button 
                  class="btn btn-sm btn-outline-danger" 
                  (click)="supprimerAnnee(annee.id!)"
                  [disabled]="isLoading() || annee.active">
                  Supprimer
                </button>
              </div>
            </div>
          }
        </div>
      </div>

      <!-- Messages -->
      @if (message()) {
        <div class="message" [class.error]="messageType() === 'error'">
          {{ message() }}
        </div>
      }
    </div>
  `,
  styles: [`
    .annee-scolaire-container {
      max-width: 1000px;
      margin: 0 auto;
      padding: 20px;
    }

    h2 {
      color: #2c3e50;
      margin-bottom: 30px;
      text-align: center;
    }

    .section {
      background: white;
      border-radius: 10px;
      padding: 20px;
      margin-bottom: 20px;
      box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }

    .section-header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 20px;
    }

    .section h3 {
      color: #34495e;
      margin: 0;
    }

    .year-card {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 15px;
      border: 2px solid #ecf0f1;
      border-radius: 8px;
      margin-bottom: 10px;
      transition: all 0.3s ease;
    }

    .year-card.active {
      border-color: #27ae60;
      background-color: #f8fff9;
    }

    .year-card:hover {
      transform: translateY(-2px);
      box-shadow: 0 4px 15px rgba(0,0,0,0.1);
    }

    .year-info h4 {
      margin: 0 0 5px 0;
      color: #2c3e50;
    }

    .year-info p {
      margin: 0 0 10px 0;
      color: #7f8c8d;
      font-size: 0.9em;
    }

    .status {
      padding: 4px 12px;
      border-radius: 20px;
      font-size: 0.8em;
      font-weight: bold;
      text-transform: uppercase;
    }

    .status.active {
      background-color: #27ae60;
      color: white;
    }

    .status:not(.active) {
      background-color: #95a5a6;
      color: white;
    }

    .year-actions {
      display: flex;
      gap: 10px;
    }

    .create-form {
      background-color: #f8f9fa;
      padding: 20px;
      border-radius: 8px;
      margin-bottom: 20px;
    }

    .form-group {
      margin-bottom: 15px;
    }

    .form-row {
      display: grid;
      grid-template-columns: 1fr 1fr;
      gap: 15px;
    }

    .form-group label {
      display: block;
      margin-bottom: 5px;
      font-weight: 500;
      color: #34495e;
    }

    .form-control {
      width: 100%;
      padding: 10px;
      border: 1px solid #ddd;
      border-radius: 4px;
      font-size: 14px;
    }

    .form-control:focus {
      outline: none;
      border-color: #3498db;
      box-shadow: 0 0 0 2px rgba(52, 152, 219, 0.2);
    }

    .form-actions {
      display: flex;
      gap: 10px;
      margin-top: 20px;
    }

    .btn {
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-weight: 500;
      transition: all 0.3s ease;
      text-decoration: none;
      display: inline-block;
      text-align: center;
    }

    .btn:disabled {
      opacity: 0.6;
      cursor: not-allowed;
    }

    .btn-primary {
      background-color: #3498db;
      color: white;
    }

    .btn-primary:hover:not(:disabled) {
      background-color: #2980b9;
    }

    .btn-success {
      background-color: #27ae60;
      color: white;
    }

    .btn-success:hover:not(:disabled) {
      background-color: #229954;
    }

    .btn-secondary {
      background-color: #95a5a6;
      color: white;
    }

    .btn-secondary:hover:not(:disabled) {
      background-color: #7f8c8d;
    }

    .btn-sm {
      padding: 6px 12px;
      font-size: 0.85em;
    }

    .btn-outline-primary {
      background-color: transparent;
      color: #3498db;
      border: 1px solid #3498db;
    }

    .btn-outline-primary:hover:not(:disabled) {
      background-color: #3498db;
      color: white;
    }

    .btn-outline-danger {
      background-color: transparent;
      color: #e74c3c;
      border: 1px solid #e74c3c;
    }

    .btn-outline-danger:hover:not(:disabled) {
      background-color: #e74c3c;
      color: white;
    }

    .no-active-year {
      text-align: center;
      padding: 30px;
      color: #e67e22;
      font-style: italic;
    }

    .message {
      position: fixed;
      top: 20px;
      right: 20px;
      padding: 15px 20px;
      border-radius: 5px;
      background-color: #27ae60;
      color: white;
      font-weight: 500;
      z-index: 1000;
      animation: slideIn 0.3s ease;
    }

    .message.error {
      background-color: #e74c3c;
    }

    @keyframes slideIn {
      from {
        transform: translateX(100%);
        opacity: 0;
      }
      to {
        transform: translateX(0);
        opacity: 1;
      }
    }

    @media (max-width: 768px) {
      .year-card {
        flex-direction: column;
        align-items: flex-start;
        gap: 15px;
      }

      .year-actions {
        width: 100%;
        justify-content: flex-end;
      }

      .form-row {
        grid-template-columns: 1fr;
      }

      .section-header {
        flex-direction: column;
        align-items: flex-start;
        gap: 15px;
      }
    }
  `]
})
export class AnneeScolaireComponent implements OnInit {
  private anneeScolaireService = inject(AnneeScolaireService);

  // Signaux
  anneeActive = signal<AnneeScolaire | null>(null);
  anneesListe = signal<AnneeScolaire[]>([]);
  isLoading = signal(false);
  message = signal('');
  messageType = signal<'success' | 'error'>('success');

  // État du formulaire
  showCreateForm = false;
  nouvelleAnnee = {
    libelle: '',
    dateDebut: '',
    dateFin: ''
  };

  async ngOnInit() {
    await this.chargerDonnees();
  }

  async chargerDonnees() {
    this.isLoading.set(true);
    try {
      // Charger l'année active
      const anneeActive = await firstValueFrom(this.anneeScolaireService.getAnneeActive());
      this.anneeActive.set(anneeActive);

      // Charger toutes les années
      const toutes = await firstValueFrom(this.anneeScolaireService.getAnneesScolaires());
      this.anneesListe.set(toutes as AnneeScolaire[]);
    } catch (error) {
      this.afficherMessage('Erreur lors du chargement des données', 'error');
    } finally {
      this.isLoading.set(false);
    }
  }

  async creerAnnee() {
    if (!this.nouvelleAnnee.libelle || !this.nouvelleAnnee.dateDebut || !this.nouvelleAnnee.dateFin) {
      this.afficherMessage('Veuillez remplir tous les champs', 'error');
      return;
    }

    this.isLoading.set(true);
    try {
      const nouvelleAnnee: Omit<AnneeScolaire, 'id'> = {
        libelle: this.nouvelleAnnee.libelle,
        dateDebut: this.nouvelleAnnee.dateDebut,
        dateFin: this.nouvelleAnnee.dateFin,
        active: false
      };

      await firstValueFrom(this.anneeScolaireService.createAnneeScolaire(nouvelleAnnee));
      
      this.afficherMessage('Année scolaire créée avec succès', 'success');
      this.annulerCreation();
      await this.chargerDonnees();
    } catch (error) {
      this.afficherMessage('Erreur lors de la création', 'error');
    } finally {
      this.isLoading.set(false);
    }
  }

  async activerAnnee(id: number) {
    this.isLoading.set(true);
    try {
      await firstValueFrom(this.anneeScolaireService.activerAnneeScolaire(id));
      this.afficherMessage('Année scolaire activée avec succès', 'success');
      await this.chargerDonnees();
    } catch (error) {
      this.afficherMessage('Erreur lors de l\'activation', 'error');
    } finally {
      this.isLoading.set(false);
    }
  }

  async supprimerAnnee(id: number) {
    if (!confirm('Êtes-vous sûr de vouloir supprimer cette année scolaire ?')) {
      return;
    }

    this.isLoading.set(true);
    try {
      await firstValueFrom(this.anneeScolaireService.deleteAnneeScolaire(id));
      this.afficherMessage('Année scolaire supprimée avec succès', 'success');
      await this.chargerDonnees();
    } catch (error) {
      this.afficherMessage('Erreur lors de la suppression', 'error');
    } finally {
      this.isLoading.set(false);
    }
  }

  annulerCreation() {
    this.showCreateForm = false;
    this.nouvelleAnnee = {
      libelle: '',
      dateDebut: '',
      dateFin: ''
    };
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

  private afficherMessage(texte: string, type: 'success' | 'error') {
    this.message.set(texte);
    this.messageType.set(type);
    setTimeout(() => {
      this.message.set('');
    }, 4000);
  }
}