export interface Eleve {
  id?: number;
  nom: string;
  prenom: string;
  dateNaissance: string;
  numeroEleve: string;
  sexe?: 'M' | 'F';
  email?: string;
  telephone?: string;
  telephoneMobile?: string;
  adresse?: string;
  codePostal?: string;
  ville?: string;
  pays?: string;
  actif?: boolean;
  dateCreation?: string;
  dateModification?: string;
}

export interface EleveRequest {
  nom: string;
  prenom: string;
  dateNaissance: string;
  numeroEleve: string;
  sexe?: 'M' | 'F';
  email?: string;
  telephone?: string;
  telephoneMobile?: string;
  adresse?: string;
  codePostal?: string;
  ville?: string;
  pays?: string;
}