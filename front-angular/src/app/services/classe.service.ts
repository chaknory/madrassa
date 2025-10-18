import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';
import { Classe, AnneeScolaire, Niveau } from '../models/classe.model';
import { PaginatedResponse } from '../models/api.model';

@Injectable({
  providedIn: 'root'
})
export class ClasseService {
  private endpoint = '/classes';
  private anneeEndpoint = '/annees-scolaires';
  private niveauEndpoint = '/niveaux';

  constructor(private apiService: ApiService) {}

  // Gestion des classes
  getClasses(page = 0, size = 20): Observable<PaginatedResponse<Classe>> {
    const params = { page, size };
    return this.apiService.get<PaginatedResponse<Classe>>(this.endpoint, params);
  }

  getClasseById(id: number): Observable<Classe> {
    return this.apiService.get<Classe>(`${this.endpoint}/${id}`);
  }

  createClasse(classe: any): Observable<Classe> {
    return this.apiService.post<Classe>(this.endpoint, classe);
  }

  updateClasse(id: number, classe: any): Observable<Classe> {
    return this.apiService.put<Classe>(`${this.endpoint}/${id}`, classe);
  }

  deleteClasse(id: number): Observable<void> {
    return this.apiService.delete<void>(`${this.endpoint}/${id}`);
  }

  // Récupérer les classes par année scolaire
  getClassesByAnnee(anneeId: number): Observable<Classe[]> {
    return this.apiService.get<Classe[]>(`${this.endpoint}/annee/${anneeId}`);
  }

  // Gestion des années scolaires (méthodes conservées pour compatibilité)
  getAnneesScolaires(): Observable<AnneeScolaire[]> {
    return this.apiService.get<AnneeScolaire[]>(this.anneeEndpoint);
  }
  
  // Note: Pour récupérer l'année active, utilisez AnneeScolaireService.getAnneeActive()
  // Cette méthode est conservée pour la compatibilité existante
  getAnneeActive(): Observable<AnneeScolaire> {
    return this.apiService.get<AnneeScolaire>(`${this.anneeEndpoint}/active`);
  }

  createAnneeScolaire(annee: Partial<AnneeScolaire>): Observable<AnneeScolaire> {
    return this.apiService.post<AnneeScolaire>(this.anneeEndpoint, annee);
  }

  // Gestion des niveaux
  getNiveaux(): Observable<Niveau[]> {
    return this.apiService.get<Niveau[]>(this.niveauEndpoint);
  }

  getNiveauById(id: number): Observable<Niveau> {
    return this.apiService.get<Niveau>(`${this.niveauEndpoint}/${id}`);
  }

  createNiveau(niveau: Partial<Niveau>): Observable<Niveau> {
    return this.apiService.post<Niveau>(this.niveauEndpoint, niveau);
  }
}