import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Subject, takeUntil } from 'rxjs';
import { TranslationService, Language } from '../../services/translation.service';

@Component({
  selector: 'app-language-selector',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="language-selector">
      <button 
        class="language-btn" 
        (click)="toggleDropdown()"
        [class.active]="isDropdownOpen">
        <span class="current-flag">{{ currentLanguage?.flag }}</span>
        <span class="current-name">{{ currentLanguage?.name }}</span>
        <span class="arrow" [class.open]="isDropdownOpen">▼</span>
      </button>
      
      <div class="language-dropdown" [class.show]="isDropdownOpen">
        <button 
          *ngFor="let language of supportedLanguages" 
          class="language-option"
          [class.selected]="language.code === currentLanguageCode"
          (click)="selectLanguage(language.code)">
          <span class="flag">{{ language.flag }}</span>
          <span class="name">{{ language.name }}</span>
          <span class="check" *ngIf="language.code === currentLanguageCode">✓</span>
        </button>
      </div>
    </div>
    
    <!-- Overlay pour fermer le dropdown -->
    <div 
      class="dropdown-overlay" 
      *ngIf="isDropdownOpen" 
      (click)="closeDropdown()">
    </div>
  `,
  styles: [`
    .language-selector {
      position: relative;
      display: inline-block;
    }

    .language-btn {
      display: flex;
      align-items: center;
      gap: 0.5rem;
      padding: 0.5rem 1rem;
      background: white;
      border: 1px solid #ddd;
      border-radius: 6px;
      cursor: pointer;
      transition: all 0.2s ease;
      font-size: 0.9rem;
      min-width: 120px;
    }

    .language-btn:hover {
      background: #f8f9fa;
      border-color: #4CAF50;
    }

    .language-btn.active {
      border-color: #4CAF50;
      box-shadow: 0 0 0 2px rgba(76, 175, 80, 0.1);
    }

    .current-flag {
      font-size: 1.2em;
    }

    .current-name {
      flex: 1;
      text-align: left;
    }

    .arrow {
      transition: transform 0.2s ease;
      font-size: 0.8em;
      color: #666;
    }

    .arrow.open {
      transform: rotate(180deg);
    }

    .language-dropdown {
      position: absolute;
      top: 100%;
      left: 0;
      right: 0;
      background: white;
      border: 1px solid #ddd;
      border-radius: 6px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
      z-index: 1000;
      opacity: 0;
      visibility: hidden;
      transform: translateY(-10px);
      transition: all 0.2s ease;
      margin-top: 4px;
    }

    .language-dropdown.show {
      opacity: 1;
      visibility: visible;
      transform: translateY(0);
    }

    .language-option {
      display: flex;
      align-items: center;
      gap: 0.75rem;
      width: 100%;
      padding: 0.75rem 1rem;
      background: none;
      border: none;
      cursor: pointer;
      transition: background-color 0.2s ease;
      font-size: 0.9rem;
      text-align: left;
    }

    .language-option:hover {
      background: #f8f9fa;
    }

    .language-option.selected {
      background: #e8f5e8;
      color: #4CAF50;
    }

    .language-option:first-child {
      border-radius: 6px 6px 0 0;
    }

    .language-option:last-child {
      border-radius: 0 0 6px 6px;
    }

    .flag {
      font-size: 1.2em;
    }

    .name {
      flex: 1;
    }

    .check {
      color: #4CAF50;
      font-weight: bold;
    }

    .dropdown-overlay {
      position: fixed;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      z-index: 999;
      background: transparent;
    }

    /* RTL Support */
    [dir="rtl"] .language-selector {
      text-align: right;
    }

    [dir="rtl"] .current-name {
      text-align: right;
    }

    [dir="rtl"] .language-option {
      text-align: right;
    }
  `]
})
export class LanguageSelectorComponent implements OnInit, OnDestroy {
  private destroy$ = new Subject<void>();
  
  supportedLanguages: Language[] = [];
  currentLanguage: Language | undefined;
  currentLanguageCode = '';
  isDropdownOpen = false;

  constructor(private translationService: TranslationService) {}

  ngOnInit() {
    this.supportedLanguages = this.translationService.supportedLanguages;
    
    // S'abonner aux changements de langue
    this.translationService.currentLang$
      .pipe(takeUntil(this.destroy$))
      .subscribe(langCode => {
        this.currentLanguageCode = langCode;
        this.currentLanguage = this.translationService.getCurrentLanguageInfo();
      });
  }

  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }

  closeDropdown() {
    this.isDropdownOpen = false;
  }

  selectLanguage(langCode: string) {
    this.translationService.setLanguage(langCode);
    this.closeDropdown();
  }
}