# Système d'Internationalisation (i18n) - Madrassa Front-End

## Vue d'ensemble

Ce système d'internationalisation permet de supporter plusieurs langues dans l'application Angular de gestion de madrassa. Il supporte actuellement :
- **Français** (fr) - langue par défaut
- **Arabe** (ar) - avec support RTL
- **Anglais** (en)

## Structure des fichiers

```
src/
├── assets/
│   └── i18n/
│       ├── fr.json    # Traductions françaises
│       ├── ar.json    # Traductions arabes
│       └── en.json    # Traductions anglaises
├── app/
│   ├── services/
│   │   └── translation.service.ts
│   ├── pipes/
│   │   └── translate.pipe.ts
│   └── components/
│       └── language-selector/
│           └── language-selector.ts
```

## Utilisation

### 1. Dans les templates HTML

```html
<!-- Traduction simple -->
<h2>{{ 'dashboard.title' | translate }}</h2>

<!-- Traduction avec paramètres -->
<p>{{ 'welcome.message' | translate: {name: userName} }}</p>
```

### 2. Dans les composants TypeScript

```typescript
import { TranslationService } from './services/translation.service';

constructor(private translationService: TranslationService) {}

// Traduction synchrone
getTitle(): string {
  return this.translationService.instant('dashboard.title');
}

// Traduction asynchrone (Observable)
title$ = this.translationService.translate('dashboard.title');
```

### 3. Ajouter le sélecteur de langue

```html
<app-language-selector></app-language-selector>
```

## Format des fichiers de traduction

Les traductions sont organisées en structure hiérarchique :

```json
{
  "dashboard": {
    "title": "Tableau de Bord",
    "stats": {
      "students": "Élèves",
      "classes": "Classes"
    },
    "quickActions": {
      "title": "Actions Rapides",
      "addStudent": "Ajouter un élève"
    }
  },
  "common": {
    "save": "Enregistrer",
    "cancel": "Annuler"
  }
}
```

## Ajouter une nouvelle langue

1. **Créer le fichier de traduction** :
   ```bash
   src/assets/i18n/es.json  # Pour l'espagnol
   ```

2. **Mettre à jour le service** :
   ```typescript
   // Dans translation.service.ts
   public supportedLanguages: Language[] = [
     { code: 'fr', name: 'Français', flag: '🇫🇷' },
     { code: 'ar', name: 'العربية', flag: '🇸🇦', rtl: true },
     { code: 'en', name: 'English', flag: '🇺🇸' },
     { code: 'es', name: 'Español', flag: '🇪🇸' } // Nouvelle langue
   ];
   ```

3. **Traduire le contenu** dans le nouveau fichier JSON.

## Support RTL (Right-to-Left)

Le système détecte automatiquement les langues RTL et applique :
- `document.dir = 'rtl'`
- Classes CSS pour l'alignement du texte
- Inversion de la direction des éléments flex

### CSS pour RTL

```css
/* Styles par défaut (LTR) */
.my-component {
  text-align: left;
  margin-left: 1rem;
}

/* Styles RTL */
[dir="rtl"] .my-component {
  text-align: right;
  margin-left: 0;
  margin-right: 1rem;
}
```

## Configuration dans un composant

### 1. Importer les dépendances

```typescript
import { TranslatePipe } from '../../pipes/translate.pipe';
import { LanguageSelectorComponent } from '../language-selector/language-selector';

@Component({
  // ...
  imports: [CommonModule, TranslatePipe, LanguageSelectorComponent],
  // ...
})
```

### 2. Utiliser dans le template

```html
<div class="header">
  <h1>{{ 'page.title' | translate }}</h1>
  <app-language-selector></app-language-selector>
</div>
```

## Bonnes pratiques

### 1. Organisation des clés

- Utilisez une structure hiérarchique logique
- Groupez par contexte (dashboard, students, classes, etc.)
- Utilisez des noms descriptifs

### 2. Clés communes

Définissez des traductions communes dans `common` :
```json
{
  "common": {
    "save": "Enregistrer",
    "cancel": "Annuler",
    "edit": "Modifier",
    "delete": "Supprimer",
    "loading": "Chargement...",
    "error": "Erreur"
  }
}
```

### 3. Paramètres dynamiques

Pour les traductions avec variables :
```json
{
  "messages": {
    "welcome": "Bienvenue {{name}} !",
    "itemCount": "{{count}} éléments trouvés"
  }
}
```

```html
<p>{{ 'messages.welcome' | translate: {name: currentUser.name} }}</p>
<p>{{ 'messages.itemCount' | translate: {count: items.length} }}</p>
```

## Persistance

- La langue sélectionnée est sauvegardée dans `localStorage`
- La langue est restaurée au rechargement de la page
- La direction RTL/LTR est automatiquement appliquée

## Performance

- Les traductions sont mises en cache après le premier chargement
- Le pipe `translate` utilise une stratégie de cache pour éviter les appels répétés
- Les fichiers de traduction sont chargés de manière asynchrone

## Gestion d'erreurs

- Fallback automatique vers le français en cas d'erreur
- Si une clé n'existe pas, elle est retournée telle quelle
- Messages d'erreur dans la console pour le débogage

## Exemple complet

```typescript
// composant.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslatePipe } from '../../pipes/translate.pipe';
import { LanguageSelectorComponent } from '../language-selector/language-selector';

@Component({
  selector: 'app-example',
  standalone: true,
  imports: [CommonModule, TranslatePipe, LanguageSelectorComponent],
  template: `
    <div class="page-header">
      <h1>{{ 'example.title' | translate }}</h1>
      <app-language-selector></app-language-selector>
    </div>
    
    <div class="content">
      <p>{{ 'example.description' | translate }}</p>
      <button>{{ 'common.save' | translate }}</button>
    </div>
  `,
  styles: [`
    .page-header {
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    
    /* Support RTL */
    [dir="rtl"] .page-header {
      flex-direction: row-reverse;
    }
  `]
})
export class ExampleComponent {}
```

Ce système d'internationalisation est maintenant prêt à être utilisé dans toute l'application !