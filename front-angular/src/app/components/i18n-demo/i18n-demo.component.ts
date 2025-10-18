import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Subject, takeUntil } from 'rxjs';
import { TranslationService } from '../../services/translation.service';
import { TranslatePipe } from '../../pipes/translate.pipe';
import { LanguageSelectorComponent } from '../language-selector/language-selector';
import { RtlSupportDirective } from '../../directives/rtl-support.directive';

@Component({
  selector: 'app-i18n-demo',
  standalone: true,
  imports: [
    CommonModule, 
    TranslatePipe, 
    LanguageSelectorComponent,
    RtlSupportDirective
  ],
  template: `
    <div class="demo-container" appRtlSupport>
      <header class="demo-header">
        <h1>{{ 'demo.title' | translate }}</h1>
        <app-language-selector></app-language-selector>
      </header>

      <main class="demo-content">
        <section class="examples-section">
          <h2>{{ 'demo.examples.title' | translate }}</h2>
          
          <!-- Exemple de traduction simple -->
          <div class="example-card">
            <h3>{{ 'demo.examples.simple.title' | translate }}</h3>
            <p>{{ 'demo.examples.simple.description' | translate }}</p>
            <code>&lt;h1&gt;{{ '{{ \\'demo.title\\' | translate }}' }}&lt;/h1&gt;</code>
          </div>

          <!-- Exemple avec paramètres -->
          <div class="example-card">
            <h3>{{ 'demo.examples.params.title' | translate }}</h3>
            <p>{{ 'demo.examples.params.message' | translate: {name: currentUser, count: itemCount} }}</p>
            <code>{{ '{{ \\'demo.welcome\\' | translate: {name: userName} }}' }}</code>
          </div>

          <!-- Exemple de direction RTL -->
          <div class="example-card">
            <h3>{{ 'demo.examples.rtl.title' | translate }}</h3>
            <div class="rtl-demo flex-row-rtl">
              <div class="demo-box">{{ 'demo.examples.rtl.box1' | translate }}</div>
              <div class="demo-box">{{ 'demo.examples.rtl.box2' | translate }}</div>
              <div class="demo-box">{{ 'demo.examples.rtl.box3' | translate }}</div>
            </div>
          </div>

          <!-- Informations sur la langue courante -->
          <div class="example-card">
            <h3>{{ 'demo.currentLang.title' | translate }}</h3>
            <div class="lang-info">
              <p><strong>{{ 'demo.currentLang.code' | translate }}:</strong> {{ currentLangInfo?.code }}</p>
              <p><strong>{{ 'demo.currentLang.name' | translate }}:</strong> {{ currentLangInfo?.name }}</p>
              <p><strong>{{ 'demo.currentLang.direction' | translate }}:</strong> 
                {{ currentLangInfo?.rtl ? ('demo.currentLang.rtl' | translate) : ('demo.currentLang.ltr' | translate) }}
              </p>
              <p><strong>{{ 'demo.currentLang.flag' | translate }}:</strong> {{ currentLangInfo?.flag }}</p>
            </div>
          </div>
        </section>

        <!-- Liste d'exemples pratiques -->
        <section class="practical-examples">
          <h2>{{ 'demo.practical.title' | translate }}</h2>
          
          <div class="example-grid">
            <div class="practical-card">
              <h4>{{ 'demo.practical.forms.title' | translate }}</h4>
              <form class="demo-form">
                <label>{{ 'demo.practical.forms.name' | translate }}</label>
                <input type="text" [placeholder]="'demo.practical.forms.namePlaceholder' | translate">
                
                <label>{{ 'demo.practical.forms.email' | translate }}</label>
                <input type="email" [placeholder]="'demo.practical.forms.emailPlaceholder' | translate">
                
                <div class="form-actions">
                  <button type="submit" class="btn btn-primary">
                    {{ 'common.save' | translate }}
                  </button>
                  <button type="button" class="btn btn-secondary">
                    {{ 'common.cancel' | translate }}
                  </button>
                </div>
              </form>
            </div>

            <div class="practical-card">
              <h4>{{ 'demo.practical.messages.title' | translate }}</h4>
              <div class="message success">
                ✅ {{ 'demo.practical.messages.success' | translate }}
              </div>
              <div class="message warning">
                ⚠️ {{ 'demo.practical.messages.warning' | translate }}
              </div>
              <div class="message error">
                ❌ {{ 'demo.practical.messages.error' | translate }}
              </div>
            </div>

            <div class="practical-card">
              <h4>{{ 'demo.practical.navigation.title' | translate }}</h4>
              <nav class="demo-nav">
                <a href="#" class="nav-link">{{ 'navigation.dashboard' | translate }}</a>
                <a href="#" class="nav-link">{{ 'navigation.students' | translate }}</a>
                <a href="#" class="nav-link">{{ 'navigation.classes' | translate }}</a>
                <a href="#" class="nav-link">{{ 'navigation.grades' | translate }}</a>
              </nav>
            </div>
          </div>
        </section>
      </main>
    </div>
  `,
  styles: [`
    .demo-container {
      max-width: 1200px;
      margin: 0 auto;
      padding: 2rem;
    }

    .demo-header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 3rem;
      padding-bottom: 1rem;
      border-bottom: 2px solid #4CAF50;
    }

    .demo-content {
      display: flex;
      flex-direction: column;
      gap: 3rem;
    }

    .examples-section {
      display: flex;
      flex-direction: column;
      gap: 2rem;
    }

    .example-card {
      background: white;
      padding: 2rem;
      border-radius: 12px;
      box-shadow: 0 4px 6px rgba(0,0,0,0.1);
    }

    .example-card h3 {
      color: #4CAF50;
      margin-bottom: 1rem;
    }

    .example-card code {
      display: block;
      background: #f5f5f5;
      padding: 1rem;
      border-radius: 6px;
      margin-top: 1rem;
      font-family: 'Courier New', monospace;
      border-left: 4px solid #4CAF50;
    }

    .rtl-demo {
      display: flex;
      gap: 1rem;
      margin-top: 1rem;
    }

    .demo-box {
      flex: 1;
      padding: 1rem;
      background: #e8f5e8;
      border-radius: 6px;
      text-align: center;
      border: 2px solid #4CAF50;
    }

    .lang-info {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
      gap: 1rem;
      margin-top: 1rem;
    }

    .lang-info p {
      padding: 0.5rem;
      background: #f8f9fa;
      border-radius: 4px;
    }

    .practical-examples {
      background: white;
      padding: 2rem;
      border-radius: 12px;
      box-shadow: 0 4px 6px rgba(0,0,0,0.1);
    }

    .example-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
      gap: 2rem;
      margin-top: 2rem;
    }

    .practical-card {
      background: #f8f9fa;
      padding: 1.5rem;
      border-radius: 8px;
      border: 1px solid #e9ecef;
    }

    .practical-card h4 {
      color: #333;
      margin-bottom: 1rem;
    }

    .demo-form {
      display: flex;
      flex-direction: column;
      gap: 1rem;
    }

    .demo-form label {
      font-weight: 600;
      color: #555;
    }

    .demo-form input {
      padding: 0.75rem;
      border: 1px solid #ddd;
      border-radius: 4px;
      font-size: 1rem;
    }

    .form-actions {
      display: flex;
      gap: 1rem;
      margin-top: 1rem;
    }

    .btn {
      padding: 0.75rem 1.5rem;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 1rem;
      transition: all 0.2s ease;
    }

    .btn-primary {
      background: #4CAF50;
      color: white;
    }

    .btn-primary:hover {
      background: #45a049;
    }

    .btn-secondary {
      background: #6c757d;
      color: white;
    }

    .btn-secondary:hover {
      background: #5a6268;
    }

    .message {
      padding: 1rem;
      border-radius: 4px;
      margin-bottom: 0.5rem;
    }

    .message.success {
      background: #d4edda;
      color: #155724;
      border: 1px solid #c3e6cb;
    }

    .message.warning {
      background: #fff3cd;
      color: #856404;
      border: 1px solid #ffeaa7;
    }

    .message.error {
      background: #f8d7da;
      color: #721c24;
      border: 1px solid #f5c6cb;
    }

    .demo-nav {
      display: flex;
      flex-direction: column;
      gap: 0.5rem;
    }

    .nav-link {
      padding: 0.75rem;
      background: white;
      border: 1px solid #ddd;
      border-radius: 4px;
      text-decoration: none;
      color: #333;
      transition: all 0.2s ease;
    }

    .nav-link:hover {
      background: #4CAF50;
      color: white;
      border-color: #4CAF50;
    }

    /* Responsive */
    @media (max-width: 768px) {
      .demo-header {
        flex-direction: column;
        gap: 1rem;
        text-align: center;
      }

      .example-grid {
        grid-template-columns: 1fr;
      }

      .form-actions {
        flex-direction: column;
      }
    }

    /* RTL Support */
    [dir="rtl"] .demo-header {
      flex-direction: row-reverse;
    }

    [dir="rtl"] .form-actions {
      flex-direction: row-reverse;
    }

    [dir="rtl"] .demo-nav {
      text-align: right;
    }
  `]
})
export class I18nDemoComponent implements OnInit, OnDestroy {
  private destroy$ = new Subject<void>();
  
  currentLangInfo: any = null;
  currentUser = 'Ahmed';
  itemCount = 42;

  constructor(private translationService: TranslationService) {}

  ngOnInit() {
    // S'abonner aux changements de langue
    this.translationService.currentLang$
      .pipe(takeUntil(this.destroy$))
      .subscribe(() => {
        this.currentLangInfo = this.translationService.getCurrentLanguageInfo();
      });
  }

  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }
}