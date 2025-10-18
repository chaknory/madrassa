import { Component, signal } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive } from '@angular/router';
import { TranslationStatusComponent } from './components/translation-status/translation-status.component';
import { TranslatePipe } from './pipes/translate.pipe';
import { LanguageSelectorComponent } from './components/language-selector/language-selector';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink, RouterLinkActive, TranslationStatusComponent, TranslatePipe, LanguageSelectorComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('front-angular');
}
