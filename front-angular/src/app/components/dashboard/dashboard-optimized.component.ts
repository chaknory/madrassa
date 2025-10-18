import { Component, signal, inject, OnInit, OnDestroy, computed } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { StateService, DashboardData } from '../../services/state.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-dashboard-optimized',
  standalone: true,
  imports: [CommonModule, RouterLink],
  template: `
    <div class="dashboard-container">
      <h1>🎓 Tableau de Bord - Madrassa</h1>
      
      <!-- Indicateur de cache -->
      <div class="cache-indicator">
        <small>
          @if (lastUpdate()) {
            Dernière mise à jour: {{ formatDateTime(lastUpdate()!) }}
          }
          @if (stateService.isCacheFresh()) {
            <span class="cache-fresh">📍 Données fraîches</span>
          } @else {
            <span class="cache-stale">⚠️ Données anciennes</span>
          }
        </small>
      </div>

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

          <div class="action-card" (click)="clearCache()">
            <div class="action-icon">🗑️</div>
            <h3>Vider le Cache</h3>
            <p>Forcer le rechargement des données</p>
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
      margin-bottom: 20px;
      font-size: 2.5rem;
    }

    .cache-indicator {
      text-align: center;
      margin-bottom: 20px;
      padding: 10px;
      background: #f8f9fa;
      border-radius: 5px;
    }

    .cache-fresh {
      color: #27ae60;
      font-weight: bold;
    }

    .cache-stale {
      color: #e67e22;
      font-weight: bold;
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
export class DashboardOptimizedComponent implements OnInit, OnDestroy {
  protected readonly stateService = inject(StateService);
  
  // Signaux locaux
  errorMessage = signal('');
  private subscription = new Subscription();

  // Signaux computed basés sur l'état global
  dashboardData = computed(() => this.stateService.dashboardData());
  isLoading = computed(() => this.stateService.isLoading());
  lastUpdate = computed(() => this.stateService.lastUpdate());

  // Statistiques calculées
  totalEleves = computed(() => this.dashboardData()?.eleves?.length || 0);
  totalClasses = computed(() => this.dashboardData()?.classes?.length || 0);
  totalNotes = computed(() => this.dashboardData()?.notes?.length || 0);
  anneeActive = computed(() => this.dashboardData()?.anneeActive);

  moyenneGenerale = computed(() => {
    const notes = this.dashboardData()?.notes || [];
    if (notes.length === 0) return '--';
    
    const somme = notes.reduce((acc: number, note: any) => acc + (note.valeur || 0), 0);
    return (somme / notes.length).toFixed(1);
  });

  ngOnInit() {
    this.loadData();
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  private loadData() {
    console.log('🎯 Dashboard: Chargement des données...');
    
    const sub = this.stateService.loadDashboardData().subscribe({
      next: (data) => {
        console.log('✅ Dashboard: Données reçues', data);
        this.errorMessage.set('');
      },
      error: (error) => {
        console.error('❌ Dashboard: Erreur', error);
        this.errorMessage.set('Erreur lors du chargement des données');
      }
    });

    this.subscription.add(sub);
  }

  refreshData() {
    console.log('🔄 Dashboard: Actualisation manuelle...');
    const sub = this.stateService.refreshDashboardData().subscribe({
      next: (data) => {
        console.log('✅ Dashboard: Données actualisées', data);
        this.errorMessage.set('');
      },
      error: (error) => {
        console.error('❌ Dashboard: Erreur lors de l\'actualisation', error);
        this.errorMessage.set('Erreur lors de l\'actualisation');
      }
    });

    this.subscription.add(sub);
  }

  clearCache() {
    console.log('🗑️ Dashboard: Vidage du cache...');
    this.stateService.clearCache();
    this.loadData();
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

  formatDateTime(date: Date): string {
    return date.toLocaleString('fr-FR', {
      day: '2-digit',
      month: '2-digit',
      year: 'numeric',
      hour: '2-digit',
      minute: '2-digit',
      second: '2-digit'
    });
  }
}