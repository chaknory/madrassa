import { Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard';
import { EleveListComponent } from './components/eleve-list/eleve-list';
import { ClasseListComponent } from './components/classe-list/classe-list';
import { NoteManagementComponent } from './components/note-management/note-management';

export const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'eleves', component: EleveListComponent },
  { path: 'classes', component: ClasseListComponent },
  { path: 'notes', component: NoteManagementComponent },
  { path: '**', redirectTo: '/dashboard' }
];
