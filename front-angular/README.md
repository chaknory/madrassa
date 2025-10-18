# 🕌 Front-end Angular - Système de Gestion Madrassa

## 📋 Description

Application Angular moderne pour la gestion d'une Madrassa, communiquant avec l'API Spring Boot existante. Cette interface web permet de gérer les élèves, les classes, les notes et les évaluations de manière intuitive et efficace.

## 🚀 Fonctionnalités

### ✅ Implémentées
- **Dashboard** : Vue d'ensemble avec statistiques
- **Gestion des Élèves** : Liste, recherche, pagination
- **Navigation responsive** : Interface adaptée aux appareils mobiles
- **Services Angular** : Communication avec l'API REST
- **Architecture modulaire** : Composants standalone Angular 18+

### 🔄 En développement
- **Gestion des Classes** : CRUD complet
- **Gestion des Notes** : Saisie et calculs
- **Formulaires** : Ajout/modification des données
- **Authentification** : Système de login
- **Rapports** : Génération de bulletins

## 🛠️ Technologies Utilisées

- **Angular 18+** (Zoneless, SSR)
- **TypeScript**
- **CSS3** (Grid, Flexbox, Animations)
- **RxJS** pour la gestion des observables
- **HttpClient** pour les appels API

## 📱 Architecture

```
src/
├── app/
│   ├── components/          # Composants UI
│   │   ├── dashboard/       # Tableau de bord
│   │   ├── eleve-list/      # Liste des élèves
│   │   ├── classe-list/     # Gestion classes (à venir)
│   │   └── note-management/ # Gestion notes (à venir)
│   ├── models/              # Types et interfaces
│   │   ├── eleve.model.ts
│   │   ├── classe.model.ts
│   │   ├── note.model.ts
│   │   └── api.model.ts
│   ├── services/            # Services Angular
│   │   ├── api.service.ts   # Service base API
│   │   ├── eleve.service.ts # Gestion élèves
│   │   ├── classe.service.ts # Gestion classes
│   │   └── note.service.ts  # Gestion notes
│   └── environments/        # Configuration environnements
└── styles.css               # Styles globaux
```

## 🔧 Installation et Démarrage

### Prérequis
- Node.js 18+
- npm ou yarn
- Angular CLI

### Démarrer l'application

```bash
# Naviguer vers le projet Angular
cd c:/Formation/madrassa/front-angular

# Installer les dépendances
npm install

# Démarrer le serveur de développement
ng serve

# L'application sera disponible sur http://localhost:4200
```

### Démarrer avec l'API

```bash
# Terminal 1 : Démarrer l'API Spring Boot
cd c:/Formation/madrassa/madrassa
mvn spring-boot:run

# Terminal 2 : Démarrer Angular
cd c:/Formation/madrassa/front-angular
ng serve
```

## 🌐 Configuration API

L'application est configurée pour communiquer avec l'API Spring Boot :

- **URL de l'API** : `http://localhost:8080/api`
- **Format** : JSON REST
- **CORS** : À configurer côté Spring Boot si nécessaire

### Configuration des environnements

```typescript
// src/environments/environment.ts
export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api'
};
```

## 📊 API Endpoints Utilisées

### Élèves
- `GET /api/eleves` - Liste paginée
- `GET /api/eleves/{id}` - Détail élève
- `POST /api/eleves` - Créer élève
- `PUT /api/eleves/{id}` - Modifier élève
- `DELETE /api/eleves/{id}` - Supprimer élève
- `GET /api/eleves/search?search=...` - Recherche

### Classes
- `GET /api/classes` - Liste des classes
- `GET /api/annees-scolaires/active` - Année active
- `GET /api/niveaux` - Liste des niveaux

### Notes
- `GET /api/notes` - Liste des notes
- `GET /api/evaluations` - Liste des évaluations

## 🎨 Interface Utilisateur

### Design System
- **Couleurs principales** : Vert (#4CAF50), Bleu (#2196F3)
- **Typographie** : Segoe UI, sans-serif
- **Composants** : Cards, Buttons, Forms modernes
- **Responsive** : Mobile-first approach

### Fonctionnalités UX
- **Loading states** : Spinners pendant les requêtes
- **Pagination** : Navigation intuitive
- **Recherche en temps réel** : Filtrage des données
- **Messages d'erreur** : Feedback utilisateur
- **Animations CSS** : Transitions fluides

## 🔐 Prochaines Étapes

1. **Formulaires complets** pour CRUD élèves
2. **Gestion des classes** avec affectation d'élèves
3. **Saisie des notes** avec calculs automatiques
4. **Authentification** et autorisation
5. **Génération de rapports** PDF
6. **Notifications** en temps réel
7. **Thème sombre** et personnalisation
8. **Tests unitaires** et e2e

## 🚀 Scripts Utiles

```bash
# Développement
ng serve                 # Serveur de dev
ng build                 # Build production
ng test                  # Tests unitaires
ng lint                  # Vérification code

# Génération de composants
ng generate component mon-composant
ng generate service mon-service
ng generate interface mon-interface

# Build pour production
ng build --prod
```

## 📝 Notes de Développement

- Application utilise Angular 18+ avec les nouvelles fonctionnalités
- Composants standalone (pas de modules NgModule)
- Zoneless change detection pour de meilleures performances
- SSR (Server-Side Rendering) configuré
- Architecture prête pour PWA (Progressive Web App)

## 🤝 Contribution

Cette application est conçue pour évoluer avec les besoins de gestion de la Madrassa. Les prochaines fonctionnalités seront développées en fonction des retours utilisateurs et des exigences métier.