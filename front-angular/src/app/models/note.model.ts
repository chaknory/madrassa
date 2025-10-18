export interface Note {
  id?: number;
  valeur: number;
  absent: boolean;
  dispense: boolean;
  appreciation?: string;
  dateSaisie?: string;
  dateModification?: string;
  evaluation?: Evaluation;
  eleve?: any; // Référence simple pour éviter les dépendances circulaires
}

export interface Evaluation {
  id?: number;
  type: string;
  dateEvaluation: string;
  coefficient: number;
  classe?: any;
  matiere?: Matiere;
}

export interface Matiere {
  id?: number;
  code: string;
  libelle: string;
  description?: string;
  coefficient: number;
  couleur?: string;
  actif: boolean;
}

export interface NoteRequest {
  idEvaluation: number;
  idEleve: number;
  valeur: number;
  absent: boolean;
  dispense: boolean;
  appreciation?: string;
}

export interface EvaluationRequest {
  idClasse: number;
  idMatiere: number;
  type: string;
  dateEvaluation: string;
  coefficient: number;
}