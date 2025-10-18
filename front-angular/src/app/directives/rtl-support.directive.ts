import { Directive, ElementRef, OnInit, OnDestroy, Renderer2 } from '@angular/core';
import { Subject, takeUntil } from 'rxjs';
import { TranslationService } from '../services/translation.service';

@Directive({
  selector: '[appRtlSupport]',
  standalone: true
})
export class RtlSupportDirective implements OnInit, OnDestroy {
  private destroy$ = new Subject<void>();

  constructor(
    private el: ElementRef,
    private renderer: Renderer2,
    private translationService: TranslationService
  ) {}

  ngOnInit() {
    // S'abonner aux changements de langue
    this.translationService.currentLang$
      .pipe(takeUntil(this.destroy$))
      .subscribe(langCode => {
        const language = this.translationService.getCurrentLanguageInfo();
        
        if (language?.rtl) {
          this.renderer.addClass(this.el.nativeElement, 'rtl-layout');
          this.renderer.removeClass(this.el.nativeElement, 'ltr-layout');
        } else {
          this.renderer.addClass(this.el.nativeElement, 'ltr-layout');
          this.renderer.removeClass(this.el.nativeElement, 'rtl-layout');
        }
      });
  }

  ngOnDestroy() {
    this.destroy$.next();
    this.destroy$.complete();
  }
}