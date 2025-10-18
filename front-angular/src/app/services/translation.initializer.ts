import { APP_INITIALIZER, Provider } from '@angular/core';
import { TranslationService } from './translation.service';

export function initializeTranslations(translationService: TranslationService) {
  return (): Promise<void> => {
    return new Promise((resolve) => {
      // S'assurer que les traductions par défaut sont chargées
      translationService.translations$.subscribe((translations) => {
        if (Object.keys(translations).length > 0) {
          resolve();
        }
      });
    });
  };
}

export const TRANSLATION_PROVIDERS: Provider[] = [
  {
    provide: APP_INITIALIZER,
    useFactory: initializeTranslations,
    deps: [TranslationService],
    multi: true
  }
];