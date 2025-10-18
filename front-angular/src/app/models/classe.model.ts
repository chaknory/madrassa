export interface Classe {
  id?: number;
  nomClasse: string;
  effectifMax: number;
  salle?: string;
  commentaire?: string;
  annee?: AnneeScolaire;
  niveau?: Niveau;
  enseignantPrincipal?: Enseignant;
}

export interface AnneeScolaire {
  id?: number;
  libelle: string;
  dateDebut: string;
  dateFin: string;
  active: boolean;
}

export interface Niveau {
  id?: number;
  code: string;
  libelle: string;
  ordre: number;
  cycle: string;
}

export interface Enseignant {
  id?: number;
  numeroEmploye: string;
  dateEmbauche: string;
  specialite: string;
  diplome?: string;
  statut: string;
  volumeHoraireHebdo: number;
  actif: boolean;
  personne?: Personne;
}

export interface Personne {
  id?: number;
  nom: string;
  prenom: string;
  dateNaissance: string;
  sexe: 'M' | 'F';
  email?: string;
  telephone?: string;
  telephoneMobile?: string;
  adresse?: string;
  codePostal?: string;
  ville?: string;
  pays?: string;
  typePersonne: string;
  actif: boolean;
}