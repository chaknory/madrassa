import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Subject, takeUntil } from 'rxjs';
import { TranslationService } from '../../services/translation.service';

@Component({
  selector: 'app-translation-status',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="translation-status" *ngIf="showStatus" [class]="statusClass">
      <span class="status-icon">{{ statusIcon }}</span>
      <span class="status-text">{{ statusText }}</span>
      <button class="close-btn" (click)="hideStatus()" *ngIf="canClose">×</button>
    </div>
  `,
  styles: [`
    .translation-status {
      position: fixed;
      top: 1rem;
      right: 1rem;
      padding: 0.75rem 1rem;
      border-radius: 6px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
      z-index: 10000;
      display: flex;
      align-items: center;
      gap: 0.5rem;
      max-width: 300px;
      font-size: 0.9rem;
      transition: all 0.3s ease;
    }

    .translation-status.loading {
      background: #fff3cd;
      border: 1px solid #ffeaa7;
      color: #856404;
    }

    .translation-status.success {
      background: #d4edda;
      border: 1px solid #c3e6cb;
      color: #155724;
    }

    .translation-status.error {
      background: #f8d7da;
      border: 1px solid #f5c6cb;
      color: #721c24;
    }

    .translation-status.warning {
      background: #fff3cd;
      border: 1px solid #ffeaa7;
      color: #856404;
    }

    .status-icon {
      font-size: 1.2em;
    }

    .status-text {
      flex: 1;
    }

    .close-btn {
      background: none;
      border: none;
      font-size: 1.2em;
      cursor: pointer;
      padding: 0;
      width: 20px;
      height: 20px;
      border-radius: 50%;
      display: flex;
      align-items: center;
      justify-content: center;
      transition: background-color 0.2s ease;
    }

    .close-btn:hover {
      background: rgba(0, 0, 0, 0.1);
    }

    /* RTL Support */
    [dir="rtl"] .translation-status {
      right: auto;
      left: 1rem;
    }

    /* Mobile responsiveness */
    @media (max-width: 768px) {
      .translation-status {
        top: auto;
        bottom: 1rem;
        left: 1rem;
        right: 1rem;
        max-width: none;
      }
    }
  `]
})
export class TranslationStatusComponent implements OnInit, OnDestroy {
  private destroy$ = new Subject<void>();
  
  showStatus = false;
  statusClass = 'loading';
  statusIcon = '⏳';
  statusText = 'Chargement des traductions...';
  canClose = false;

  constructor(private translationService: TranslationService) {}

  ngOnInit() {
    // Montrer le statut au démarrage
    this.showLoadingStatus();

    // S'abonner aux changements de traductions
    this.translationService.translations$
      .pipe(takeUntil(this.destroy$))
      .subscribe(translations => {
        if (Object.keys(translations).length > 0) {
          this.showSuccessStatus();
          // Cacher automatiquement après 3 secondes
          setTimeout(() => {
            this.hideStatus();
          }, 3000);
        }
      });

    // S'abonner aux changements de langue
    this.translationService.currentLang$
      .pipe(takeUntil(this.destroy$))
      .subscribe(langCode => {
        const language = this.translationService.getCurrentLanguageInfo();
        if (language) {
          this.showLanguageChangeStatus(language.name);
        }
      });
  }

  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }

  showLoadingStatus() {
    this.showStatus = true;
    this.statusClass = 'loading';
    this.statusIcon = '⏳';
    this.statusText = 'Chargement des traductions...';
    this.canClose = false;
  }

  showSuccessStatus() {
    this.statusClass = 'success';
    this.statusIcon = '✅';
    this.statusText = 'Traductions chargées avec succès';
    this.canClose = true;
  }

  showLanguageChangeStatus(languageName: string) {
    this.showStatus = true;
    this.statusClass = 'success';
    this.statusIcon = '🌍';
    this.statusText = `Langue changée vers: ${languageName}`;
    this.canClose = true;
    
    // Cacher automatiquement après 2 secondes
    setTimeout(() => {
      this.hideStatus();
    }, 2000);
  }

  showErrorStatus(message: string) {
    this.showStatus = true;
    this.statusClass = 'error';
    this.statusIcon = '❌';
    this.statusText = message;
    this.canClose = true;
  }

  showWarningStatus(message: string) {
    this.showStatus = true;
    this.statusClass = 'warning';
    this.statusIcon = '⚠️';
    this.statusText = message;
    this.canClose = true;
  }

  hideStatus() {
    this.showStatus = false;
  }
}