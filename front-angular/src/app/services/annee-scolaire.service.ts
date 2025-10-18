import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';
import { AnneeScolaire } from '../models/classe.model';

@Injectable({
  providedIn: 'root'
})
export class AnneeScolaireService {
  private endpoint = '/annees-scolaires';

  constructor(private apiService: ApiService) {}

  // Récupérer toutes les années scolaires
  getAnneesScolaires(): Observable<AnneeScolaire[]> {
    return this.apiService.get<AnneeScolaire[]>(this.endpoint);
  }

  // Récupérer l'année scolaire active
  getAnneeActive(): Observable<AnneeScolaire> {
    return this.apiService.get<AnneeScolaire>(`${this.endpoint}/active`);
  }

  // Récupérer une année scolaire par ID
  getAnneeScolaireById(id: number): Observable<AnneeScolaire> {
    return this.apiService.get<AnneeScolaire>(`${this.endpoint}/${id}`);
  }

  // Créer une nouvelle année scolaire
  createAnneeScolaire(annee: Partial<AnneeScolaire>): Observable<AnneeScolaire> {
    return this.apiService.post<AnneeScolaire>(this.endpoint, annee);
  }

  // Mettre à jour une année scolaire
  updateAnneeScolaire(id: number, annee: Partial<AnneeScolaire>): Observable<AnneeScolaire> {
    return this.apiService.put<AnneeScolaire>(`${this.endpoint}/${id}`, annee);
  }

  // Supprimer une année scolaire
  deleteAnneeScolaire(id: number): Observable<void> {
    return this.apiService.delete<void>(`${this.endpoint}/${id}`);
  }

  // Activer une année scolaire (désactive les autres)
  activerAnneeScolaire(id: number): Observable<AnneeScolaire> {
    return this.apiService.patch<AnneeScolaire>(`${this.endpoint}/${id}/activer`, {});
  }

  // Vérifier si une année est active
  isAnneeActive(annee: AnneeScolaire): boolean {
    return annee.active === true;
  }

  // Vérifier si une année est en cours (dates actuelles)
  isAnneeEnCours(annee: AnneeScolaire): boolean {
    const today = new Date();
    const dateDebut = new Date(annee.dateDebut);
    const dateFin = new Date(annee.dateFin);
    
    return today >= dateDebut && today <= dateFin;
  }

  // Obtenir le libellé formaté d'une année
  getLibelleFormate(annee: AnneeScolaire): string {
    return `${annee.libelle} (${this.formatDate(annee.dateDebut)} - ${this.formatDate(annee.dateFin)})`;
  }

  // Formater une date en français
  private formatDate(dateString: string): string {
    return new Date(dateString).toLocaleDateString('fr-FR', {
      day: '2-digit',
      month: '2-digit', 
      year: 'numeric'
    });
  }
}