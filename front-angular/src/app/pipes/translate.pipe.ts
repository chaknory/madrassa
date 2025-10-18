import { Pipe, PipeTransform, OnDestroy } from '@angular/core';
import { Subject, takeUntil } from 'rxjs';
import { TranslationService } from '../services/translation.service';

@Pipe({
  name: 'translate',
  standalone: true,
  pure: false // Pour réagir aux changements de langue
})
export class TranslatePipe implements PipeTransform, OnDestroy {
  private destroy$ = new Subject<void>();
  private lastKey = '';
  private lastParams: any = {};
  private lastTranslation = '';

  constructor(private translationService: TranslationService) {
    // S'abonner aux changements de traductions
    this.translationService.translations$
      .pipe(takeUntil(this.destroy$))
      .subscribe(() => {
        // Invalider le cache quand les traductions changent
        this.lastKey = '';
      });
  }

  transform(key: string, params?: any): string {
    // Optimisation : éviter les appels inutiles
    if (key === this.lastKey && JSON.stringify(params) === JSON.stringify(this.lastParams)) {
      return this.lastTranslation;
    }

    this.lastKey = key;
    this.lastParams = params;
    this.lastTranslation = this.translationService.translateSync(key, params);
    
    return this.lastTranslation;
  }

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }
}