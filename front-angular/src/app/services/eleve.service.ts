import { Injectable } from '@angular/core';
import { Observable, timeout, catchError, throwError } from 'rxjs';
import { ApiService } from './api.service';
import { Eleve, EleveRequest } from '../models/eleve.model';
import { PaginatedResponse } from '../models/api.model';

@Injectable({
  providedIn: 'root'
})
export class EleveService {
  private endpoint = '/eleves';

  constructor(private apiService: ApiService) {}

  // Récupérer tous les élèves (simple liste sans pagination)
  getAllEleves(): Observable<Eleve[]> {
    console.log('🔄 Appel API getAllEleves...');
    return this.apiService.get<Eleve[]>(this.endpoint).pipe(
      timeout(10000), // Timeout de 10 secondes
      catchError(error => {
        console.error('❌ Erreur lors du chargement des élèves:', error);
        return throwError(() => new Error('Impossible de charger les élèves'));
      })
    );
  }

  // Récupérer tous les élèves avec pagination
  getEleves(page = 0, size = 20, sort = 'nom', direction = 'asc'): Observable<PaginatedResponse<Eleve>> {
    const params = { page, size, sort, direction };
    console.log('============================================================================================');
    console.log('Fetching eleves with params:', this.apiService.get<PaginatedResponse<Eleve>>(this.endpoint, params) );
    return this.apiService.get<PaginatedResponse<Eleve>>(this.endpoint, params);
  }

  // Récupérer un élève par ID
  getEleveById(id: number): Observable<Eleve> {
    return this.apiService.get<Eleve>(`${this.endpoint}/${id}`);
  }

  // Créer un nouvel élève
  createEleve(eleve: EleveRequest): Observable<Eleve> {
    return this.apiService.post<Eleve>(this.endpoint, eleve);
  }

  // Mettre à jour un élève
  updateEleve(id: number, eleve: EleveRequest): Observable<Eleve> {
    return this.apiService.put<Eleve>(`${this.endpoint}/${id}`, eleve);
  }

  // Supprimer un élève
  deleteEleve(id: number): Observable<void> {
    return this.apiService.delete<void>(`${this.endpoint}/${id}`);
  }

  // Rechercher des élèves
  searchEleves(query: string, page = 0, size = 20): Observable<PaginatedResponse<Eleve>> {
    const params = { search: query, page, size };
    return this.apiService.get<PaginatedResponse<Eleve>>(`${this.endpoint}/search`, params);
  }

  // Récupérer les élèves d'une classe
  getElevesByClasse(classeId: number): Observable<Eleve[]> {
    return this.apiService.get<Eleve[]>(`${this.endpoint}/classe/${classeId}`);
  }
}