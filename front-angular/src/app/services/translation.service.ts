import { Injectable, Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, of, timer } from 'rxjs';
import { map, catchError, timeout, retryWhen, take, delay } from 'rxjs/operators';
import { EMBEDDED_TRANSLATIONS } from './embedded-translations';

export interface Language {
  code: string;
  name: string;
  flag: string;
  rtl?: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class TranslationService {
  private currentLangSubject = new BehaviorSubject<string>('fr');
  private translationsSubject = new BehaviorSubject<any>({});

  public currentLang$ = this.currentLangSubject.asObservable();
  public translations$ = this.translationsSubject.asObservable();

  private translations: any = {};

  // Traductions par défaut en français (fallback)
  private defaultTranslations = {
    'app.title': 'Système de Gestion Madrassa',
    'dashboard.title': 'Tableau de Bord',
    'dashboard.schoolYear': 'Année Scolaire',
    'dashboard.stats.students': 'Élèves',
    'dashboard.stats.classes': 'Classes',
    'dashboard.stats.grades': 'Notes',
    'dashboard.stats.reports': 'Rapports',
    'dashboard.quickActions.title': 'Actions Rapides',
    'dashboard.quickActions.addStudent': 'Ajouter un élève',
    'dashboard.quickActions.createClass': 'Créer une classe',
    'dashboard.quickActions.enterGrades': 'Saisir des notes',
    'dashboard.quickActions.generateReport': 'Générer un bulletin',
    'dashboard.loading': 'Chargement des données...',
    'dashboard.viewAllStudents': 'Voir tous les élèves',
    'dashboard.manageClasses': 'Gérer les classes',
    'dashboard.manageGrades': 'Gérer les notes',
    'dashboard.generateReports': 'Générer des rapports',
    'dashboard.reportsDescription': 'Bulletins et statistiques',
    'dashboard.notDefined': 'Non définie',
    'dashboard.connectionError': 'Erreur de connexion',
    'students.title': 'Gestion des Élèves',
    'classes.title': 'Gestion des Classes',
    'classes.comingSoon': 'Fonctionnalité en développement',
    'classes.description': 'La gestion des classes sera bientôt disponible.',
    'grades.title': 'Gestion des Notes',
    'grades.comingSoon': 'Fonctionnalité en développement',
    'grades.description': 'La gestion des notes sera bientôt disponible.',
    'navigation.dashboard': 'Tableau de bord',
    'navigation.students': 'Élèves',
    'navigation.classes': 'Classes',
    'navigation.grades': 'Notes',
    'common.save': 'Enregistrer',
    'common.cancel': 'Annuler',
    'common.close': 'Fermer',
    'common.yes': 'Oui',
    'common.no': 'Non'
  };

  public supportedLanguages: Language[] = [
    { code: 'fr', name: 'Français', flag: '🇫🇷' },
    { code: 'ar', name: 'العربية', flag: 'AR', rtl: true },
    { code: 'en', name: 'English', flag: '🇺🇸' }
  ];

  constructor(
    private http: HttpClient,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {
    // Initialiser avec les traductions embarquées
    this.translations = { ...EMBEDDED_TRANSLATIONS };
    this.translationsSubject.next(EMBEDDED_TRANSLATIONS.fr);
    
    // Essayer de charger les traductions depuis les fichiers (amélioration)
    this.loadTranslations('fr');
    
    // Récupérer la langue depuis le localStorage si disponible (seulement côté client)
    if (isPlatformBrowser(this.platformId)) {
      const savedLang = localStorage.getItem('selectedLanguage');
      if (savedLang && this.supportedLanguages.some(lang => lang.code === savedLang)) {
        this.setLanguage(savedLang);
      }
    }
  }

  public setLanguage(langCode: string): void {
    if (this.supportedLanguages.some(lang => lang.code === langCode)) {
      this.currentLangSubject.next(langCode);
      this.loadTranslations(langCode);
      
      // Sauvegarder seulement côté client
      if (isPlatformBrowser(this.platformId)) {
        localStorage.setItem('selectedLanguage', langCode);
      }
      
      // Gérer la direction RTL/LTR seulement côté client
      if (isPlatformBrowser(this.platformId)) {
        const language = this.supportedLanguages.find(lang => lang.code === langCode);
        document.dir = language?.rtl ? 'rtl' : 'ltr';
        document.documentElement.lang = langCode;
      }
    }
  }

  public getCurrentLanguage(): string {
    return this.currentLangSubject.value;
  }

  public getCurrentLanguageInfo(): Language | undefined {
    return this.supportedLanguages.find(lang => lang.code === this.getCurrentLanguage());
  }

  private loadTranslations(langCode: string): void {
    // Utiliser d'abord les traductions embarquées
    if (EMBEDDED_TRANSLATIONS[langCode as keyof typeof EMBEDDED_TRANSLATIONS]) {
      this.translations[langCode] = EMBEDDED_TRANSLATIONS[langCode as keyof typeof EMBEDDED_TRANSLATIONS];
      this.translationsSubject.next(this.translations[langCode]);
      console.log(`Traductions embarquées chargées pour ${langCode}`);
    }

    // Essayer de charger les traductions améliorées depuis les fichiers
    if (isPlatformBrowser(this.platformId)) {
      this.http.get(`/assets/i18n/${langCode}.json`)
        .pipe(
          timeout(3000), // Timeout réduit à 3 secondes
          catchError(error => {
            console.log(`Utilisation des traductions embarquées pour ${langCode} (fichier non accessible)`);
            return of(null); // Retourner null au lieu de lever une erreur
          })
        )
        .subscribe({
          next: (fileTranslations) => {
            if (fileTranslations) {
              // Fusionner avec les traductions embarquées (le fichier a priorité)
              this.translations[langCode] = {
                ...this.translations[langCode],
                ...fileTranslations
              };
              this.translationsSubject.next(this.translations[langCode]);
              console.log(`Traductions du fichier chargées et fusionnées pour ${langCode}`);
            }
          },
          error: (error) => {
            console.log(`Erreur lors du chargement du fichier pour ${langCode}, utilisation des traductions embarquées`);
          }
        });
    }
  }

  public translate(key: string, params?: any): Observable<string> {
    return this.translations$.pipe(
      map(translations => {
        const translation = this.getNestedTranslation(translations, key);
        return this.interpolate(translation, params);
      })
    );
  }

  public translateSync(key: string, params?: any): string {
    const currentTranslations = this.translationsSubject.value;
    const translation = this.getNestedTranslation(currentTranslations, key);
    return this.interpolate(translation, params);
  }

  private getNestedTranslation(translations: any, key: string): string {
    const translation = key.split('.').reduce((obj, k) => obj && obj[k], translations);
    
    // Si la traduction n'existe pas, essayer dans les traductions embarquées
    if (!translation && translations !== EMBEDDED_TRANSLATIONS.fr) {
      return this.getNestedTranslation(EMBEDDED_TRANSLATIONS.fr, key);
    }
    
    return translation || key;
  }

  private interpolate(text: string, params?: any): string {
    if (!params) return text;
    
    return Object.keys(params).reduce((result, key) => {
      return result.replace(new RegExp(`{{\\s*${key}\\s*}}`, 'g'), params[key]);
    }, text);
  }

  // Méthode utilitaire pour obtenir une traduction directement
  public instant(key: string, params?: any): string {
    return this.translateSync(key, params);
  }
}