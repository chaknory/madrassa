import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';
import { Note, NoteRequest, Evaluation, EvaluationRequest } from '../models/note.model';
import { PaginatedResponse } from '../models/api.model';

@Injectable({
  providedIn: 'root'
})
export class NoteService {
  private endpoint = '/notes';
  private evaluationEndpoint = '/evaluations';

  constructor(private apiService: ApiService) {}

  // Gestion des notes
  getNotes(page = 0, size = 20): Observable<PaginatedResponse<Note>> {
    const params = { page, size };
    return this.apiService.get<PaginatedResponse<Note>>(this.endpoint, params);
  }

  getNoteById(id: number): Observable<Note> {
    return this.apiService.get<Note>(`${this.endpoint}/${id}`);
  }

  createNote(note: NoteRequest): Observable<Note> {
    return this.apiService.post<Note>(this.endpoint, note);
  }

  updateNote(id: number, note: NoteRequest): Observable<Note> {
    return this.apiService.put<Note>(`${this.endpoint}/${id}`, note);
  }

  deleteNote(id: number): Observable<void> {
    return this.apiService.delete<void>(`${this.endpoint}/${id}`);
  }

  // Récupérer les notes d'un élève
  getNotesByEleve(eleveId: number): Observable<Note[]> {
    return this.apiService.get<Note[]>(`${this.endpoint}/eleve/${eleveId}`);
  }

  // Récupérer les notes d'une évaluation
  getNotesByEvaluation(evaluationId: number): Observable<Note[]> {
    return this.apiService.get<Note[]>(`${this.endpoint}/evaluation/${evaluationId}`);
  }

  // Gestion des évaluations
  getEvaluations(page = 0, size = 20): Observable<PaginatedResponse<Evaluation>> {
    const params = { page, size };
    return this.apiService.get<PaginatedResponse<Evaluation>>(this.evaluationEndpoint, params);
  }

  getEvaluationById(id: number): Observable<Evaluation> {
    return this.apiService.get<Evaluation>(`${this.evaluationEndpoint}/${id}`);
  }

  createEvaluation(evaluation: EvaluationRequest): Observable<Evaluation> {
    return this.apiService.post<Evaluation>(this.evaluationEndpoint, evaluation);
  }

  updateEvaluation(id: number, evaluation: EvaluationRequest): Observable<Evaluation> {
    return this.apiService.put<Evaluation>(`${this.evaluationEndpoint}/${id}`, evaluation);
  }

  deleteEvaluation(id: number): Observable<void> {
    return this.apiService.delete<void>(`${this.evaluationEndpoint}/${id}`);
  }

  // Récupérer les évaluations d'une classe
  getEvaluationsByClasse(classeId: number): Observable<Evaluation[]> {
    return this.apiService.get<Evaluation[]>(`${this.evaluationEndpoint}/classe/${classeId}`);
  }

  // Calcul des moyennes
  getMoyenneEleve(eleveId: number, periode?: number): Observable<number> {
    const params = periode ? { periode } : {};
    return this.apiService.get<number>(`${this.endpoint}/eleve/${eleveId}/moyenne`, params);
  }

  getMoyenneClasse(classeId: number, matiereId?: number): Observable<number> {
    const params = matiereId ? { matiere: matiereId } : {};
    return this.apiService.get<number>(`${this.endpoint}/classe/${classeId}/moyenne`, params);
  }
}