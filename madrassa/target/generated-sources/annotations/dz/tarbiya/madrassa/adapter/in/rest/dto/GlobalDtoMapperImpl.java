package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Absence;
import dz.tarbiya.madrassa.domain.model.AnneeScolaire;
import dz.tarbiya.madrassa.domain.model.Bulletin;
import dz.tarbiya.madrassa.domain.model.BulletinDetail;
import dz.tarbiya.madrassa.domain.model.Classe;
import dz.tarbiya.madrassa.domain.model.Cours;
import dz.tarbiya.madrassa.domain.model.Eleve;
import dz.tarbiya.madrassa.domain.model.Enseignant;
import dz.tarbiya.madrassa.domain.model.Evaluation;
import dz.tarbiya.madrassa.domain.model.HoraireCours;
import dz.tarbiya.madrassa.domain.model.Inscription;
import dz.tarbiya.madrassa.domain.model.Matiere;
import dz.tarbiya.madrassa.domain.model.Niveau;
import dz.tarbiya.madrassa.domain.model.Note;
import dz.tarbiya.madrassa.domain.model.Periode;
import dz.tarbiya.madrassa.domain.model.Personne;
import dz.tarbiya.madrassa.domain.model.Personnel;
import dz.tarbiya.madrassa.domain.model.ResponsableLegal;
import dz.tarbiya.madrassa.domain.model.Retard;
import dz.tarbiya.madrassa.domain.model.TypeEvaluation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:29+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class GlobalDtoMapperImpl implements GlobalDtoMapper {

    @Override
    public PersonneDTO toDto(Personne personne) {
        if ( personne == null ) {
            return null;
        }

        Long idPersonne = null;
        String nom = null;
        String prenom = null;
        LocalDate dateNaissance = null;
        String sexe = null;
        String email = null;
        String telephone = null;
        String telephoneMobile = null;
        String adresse = null;
        String codePostal = null;
        String ville = null;
        String pays = null;
        String photoUrl = null;
        String typePersonne = null;
        Boolean actif = null;
        LocalDateTime dateCreation = null;
        LocalDateTime dateModification = null;

        idPersonne = personne.idPersonne();
        nom = personne.nom();
        prenom = personne.prenom();
        dateNaissance = personne.dateNaissance();
        sexe = personne.sexe();
        email = personne.email();
        telephone = personne.telephone();
        telephoneMobile = personne.telephoneMobile();
        adresse = personne.adresse();
        codePostal = personne.codePostal();
        ville = personne.ville();
        pays = personne.pays();
        photoUrl = personne.photoUrl();
        typePersonne = personne.typePersonne();
        actif = personne.actif();
        dateCreation = personne.dateCreation();
        dateModification = personne.dateModification();

        PersonneDTO personneDTO = new PersonneDTO( idPersonne, nom, prenom, dateNaissance, sexe, email, telephone, telephoneMobile, adresse, codePostal, ville, pays, photoUrl, typePersonne, actif, dateCreation, dateModification );

        return personneDTO;
    }

    @Override
    public Personne toDomain(PersonneDTO personneDTO) {
        if ( personneDTO == null ) {
            return null;
        }

        Long idPersonne = null;
        String nom = null;
        String prenom = null;
        LocalDate dateNaissance = null;
        String sexe = null;
        String email = null;
        String telephone = null;
        String telephoneMobile = null;
        String adresse = null;
        String codePostal = null;
        String ville = null;
        String pays = null;
        String photoUrl = null;
        String typePersonne = null;
        Boolean actif = null;
        LocalDateTime dateCreation = null;
        LocalDateTime dateModification = null;

        idPersonne = personneDTO.idPersonne();
        nom = personneDTO.nom();
        prenom = personneDTO.prenom();
        dateNaissance = personneDTO.dateNaissance();
        sexe = personneDTO.sexe();
        email = personneDTO.email();
        telephone = personneDTO.telephone();
        telephoneMobile = personneDTO.telephoneMobile();
        adresse = personneDTO.adresse();
        codePostal = personneDTO.codePostal();
        ville = personneDTO.ville();
        pays = personneDTO.pays();
        photoUrl = personneDTO.photoUrl();
        typePersonne = personneDTO.typePersonne();
        actif = personneDTO.actif();
        dateCreation = personneDTO.dateCreation();
        dateModification = personneDTO.dateModification();

        Personne personne = new Personne( idPersonne, nom, prenom, dateNaissance, sexe, email, telephone, telephoneMobile, adresse, codePostal, ville, pays, photoUrl, typePersonne, actif, dateCreation, dateModification );

        return personne;
    }

    @Override
    public EleveDTO toDto(Eleve eleve) {
        if ( eleve == null ) {
            return null;
        }

        Long id = null;
        String nom = null;
        String prenom = null;
        LocalDate dateNaissance = null;
        String numeroEleve = null;

        id = eleve.id();
        nom = eleve.nom();
        prenom = eleve.prenom();
        dateNaissance = eleve.dateNaissance();
        numeroEleve = eleve.numeroEleve();

        EleveDTO eleveDTO = new EleveDTO( id, nom, prenom, dateNaissance, numeroEleve );

        return eleveDTO;
    }

    @Override
    public Eleve toDomain(EleveDTO eleveDTO) {
        if ( eleveDTO == null ) {
            return null;
        }

        Long id = null;
        String nom = null;
        String prenom = null;
        LocalDate dateNaissance = null;
        String numeroEleve = null;

        id = eleveDTO.id();
        nom = eleveDTO.nom();
        prenom = eleveDTO.prenom();
        dateNaissance = eleveDTO.dateNaissance();
        numeroEleve = eleveDTO.numeroEleve();

        Eleve eleve = new Eleve( id, nom, prenom, dateNaissance, numeroEleve );

        return eleve;
    }

    @Override
    public EnseignantDTO toDto(Enseignant enseignant) {
        if ( enseignant == null ) {
            return null;
        }

        Long idEnseignant = null;
        Long idPersonne = null;
        String numeroEmploye = null;
        LocalDate dateEmbauche = null;
        String specialite = null;
        String diplome = null;
        String statut = null;
        Double volumeHoraireHebdo = null;
        Boolean actif = null;

        idEnseignant = enseignant.idEnseignant();
        idPersonne = enseignant.idPersonne();
        numeroEmploye = enseignant.numeroEmploye();
        dateEmbauche = enseignant.dateEmbauche();
        specialite = enseignant.specialite();
        diplome = enseignant.diplome();
        statut = enseignant.statut();
        volumeHoraireHebdo = enseignant.volumeHoraireHebdo();
        actif = enseignant.actif();

        EnseignantDTO enseignantDTO = new EnseignantDTO( idEnseignant, idPersonne, numeroEmploye, dateEmbauche, specialite, diplome, statut, volumeHoraireHebdo, actif );

        return enseignantDTO;
    }

    @Override
    public Enseignant toDomain(EnseignantDTO enseignantDTO) {
        if ( enseignantDTO == null ) {
            return null;
        }

        Long idEnseignant = null;
        Long idPersonne = null;
        String numeroEmploye = null;
        LocalDate dateEmbauche = null;
        String specialite = null;
        String diplome = null;
        String statut = null;
        Double volumeHoraireHebdo = null;
        Boolean actif = null;

        idEnseignant = enseignantDTO.idEnseignant();
        idPersonne = enseignantDTO.idPersonne();
        numeroEmploye = enseignantDTO.numeroEmploye();
        dateEmbauche = enseignantDTO.dateEmbauche();
        specialite = enseignantDTO.specialite();
        diplome = enseignantDTO.diplome();
        statut = enseignantDTO.statut();
        volumeHoraireHebdo = enseignantDTO.volumeHoraireHebdo();
        actif = enseignantDTO.actif();

        Enseignant enseignant = new Enseignant( idEnseignant, idPersonne, numeroEmploye, dateEmbauche, specialite, diplome, statut, volumeHoraireHebdo, actif );

        return enseignant;
    }

    @Override
    public PersonnelDTO toDto(Personnel personnel) {
        if ( personnel == null ) {
            return null;
        }

        Long idPersonnel = null;
        Long idPersonne = null;
        String numeroEmploye = null;
        String fonction = null;
        LocalDate dateEmbauche = null;
        String service = null;
        Boolean actif = null;

        idPersonnel = personnel.idPersonnel();
        idPersonne = personnel.idPersonne();
        numeroEmploye = personnel.numeroEmploye();
        fonction = personnel.fonction();
        dateEmbauche = personnel.dateEmbauche();
        service = personnel.service();
        actif = personnel.actif();

        PersonnelDTO personnelDTO = new PersonnelDTO( idPersonnel, idPersonne, numeroEmploye, fonction, dateEmbauche, service, actif );

        return personnelDTO;
    }

    @Override
    public Personnel toDomain(PersonnelDTO personnelDTO) {
        if ( personnelDTO == null ) {
            return null;
        }

        Long idPersonnel = null;
        Long idPersonne = null;
        String numeroEmploye = null;
        String fonction = null;
        LocalDate dateEmbauche = null;
        String service = null;
        Boolean actif = null;

        idPersonnel = personnelDTO.idPersonnel();
        idPersonne = personnelDTO.idPersonne();
        numeroEmploye = personnelDTO.numeroEmploye();
        fonction = personnelDTO.fonction();
        dateEmbauche = personnelDTO.dateEmbauche();
        service = personnelDTO.service();
        actif = personnelDTO.actif();

        Personnel personnel = new Personnel( idPersonnel, idPersonne, numeroEmploye, fonction, dateEmbauche, service, actif );

        return personnel;
    }

    @Override
    public ResponsableLegalDTO toDto(ResponsableLegal responsableLegal) {
        if ( responsableLegal == null ) {
            return null;
        }

        Long idResponsable = null;
        String nom = null;
        String prenom = null;
        String telephone = null;
        String telephoneMobile = null;
        String email = null;
        String adresse = null;
        String profession = null;
        String lienParente = null;
        Boolean contactUrgence = null;
        Boolean autoriseSortie = null;
        LocalDateTime dateCreation = null;

        idResponsable = responsableLegal.idResponsable();
        nom = responsableLegal.nom();
        prenom = responsableLegal.prenom();
        telephone = responsableLegal.telephone();
        telephoneMobile = responsableLegal.telephoneMobile();
        email = responsableLegal.email();
        adresse = responsableLegal.adresse();
        profession = responsableLegal.profession();
        lienParente = responsableLegal.lienParente();
        contactUrgence = responsableLegal.contactUrgence();
        autoriseSortie = responsableLegal.autoriseSortie();
        dateCreation = responsableLegal.dateCreation();

        ResponsableLegalDTO responsableLegalDTO = new ResponsableLegalDTO( idResponsable, nom, prenom, telephone, telephoneMobile, email, adresse, profession, lienParente, contactUrgence, autoriseSortie, dateCreation );

        return responsableLegalDTO;
    }

    @Override
    public ResponsableLegal toDomain(ResponsableLegalDTO responsableLegalDTO) {
        if ( responsableLegalDTO == null ) {
            return null;
        }

        Long idResponsable = null;
        String nom = null;
        String prenom = null;
        String telephone = null;
        String telephoneMobile = null;
        String email = null;
        String adresse = null;
        String profession = null;
        String lienParente = null;
        Boolean contactUrgence = null;
        Boolean autoriseSortie = null;
        LocalDateTime dateCreation = null;

        idResponsable = responsableLegalDTO.idResponsable();
        nom = responsableLegalDTO.nom();
        prenom = responsableLegalDTO.prenom();
        telephone = responsableLegalDTO.telephone();
        telephoneMobile = responsableLegalDTO.telephoneMobile();
        email = responsableLegalDTO.email();
        adresse = responsableLegalDTO.adresse();
        profession = responsableLegalDTO.profession();
        lienParente = responsableLegalDTO.lienParente();
        contactUrgence = responsableLegalDTO.contactUrgence();
        autoriseSortie = responsableLegalDTO.autoriseSortie();
        dateCreation = responsableLegalDTO.dateCreation();

        ResponsableLegal responsableLegal = new ResponsableLegal( idResponsable, nom, prenom, telephone, telephoneMobile, email, adresse, profession, lienParente, contactUrgence, autoriseSortie, dateCreation );

        return responsableLegal;
    }

    @Override
    public AnneeScolaireDTO toDto(AnneeScolaire anneeScolaire) {
        if ( anneeScolaire == null ) {
            return null;
        }

        Long idAnnee = null;
        String libelle = null;
        LocalDate dateDebut = null;
        LocalDate dateFin = null;
        Boolean active = null;

        idAnnee = anneeScolaire.idAnnee();
        libelle = anneeScolaire.libelle();
        dateDebut = anneeScolaire.dateDebut();
        dateFin = anneeScolaire.dateFin();
        active = anneeScolaire.active();

        AnneeScolaireDTO anneeScolaireDTO = new AnneeScolaireDTO( idAnnee, libelle, dateDebut, dateFin, active );

        return anneeScolaireDTO;
    }

    @Override
    public AnneeScolaire toDomain(AnneeScolaireDTO anneeScolaireDTO) {
        if ( anneeScolaireDTO == null ) {
            return null;
        }

        Long idAnnee = null;
        String libelle = null;
        LocalDate dateDebut = null;
        LocalDate dateFin = null;
        Boolean active = null;

        idAnnee = anneeScolaireDTO.idAnnee();
        libelle = anneeScolaireDTO.libelle();
        dateDebut = anneeScolaireDTO.dateDebut();
        dateFin = anneeScolaireDTO.dateFin();
        active = anneeScolaireDTO.active();

        AnneeScolaire anneeScolaire = new AnneeScolaire( idAnnee, libelle, dateDebut, dateFin, active );

        return anneeScolaire;
    }

    @Override
    public NiveauDTO toDto(Niveau niveau) {
        if ( niveau == null ) {
            return null;
        }

        Long idNiveau = null;
        String code = null;
        String libelle = null;
        Integer ordre = null;
        String cycle = null;

        idNiveau = niveau.idNiveau();
        code = niveau.code();
        libelle = niveau.libelle();
        ordre = niveau.ordre();
        cycle = niveau.cycle();

        NiveauDTO niveauDTO = new NiveauDTO( idNiveau, code, libelle, ordre, cycle );

        return niveauDTO;
    }

    @Override
    public Niveau toDomain(NiveauDTO niveauDTO) {
        if ( niveauDTO == null ) {
            return null;
        }

        Long idNiveau = null;
        String code = null;
        String libelle = null;
        Integer ordre = null;
        String cycle = null;

        idNiveau = niveauDTO.idNiveau();
        code = niveauDTO.code();
        libelle = niveauDTO.libelle();
        ordre = niveauDTO.ordre();
        cycle = niveauDTO.cycle();

        Niveau niveau = new Niveau( idNiveau, code, libelle, ordre, cycle );

        return niveau;
    }

    @Override
    public ClasseDTO toDto(Classe classe) {
        if ( classe == null ) {
            return null;
        }

        Long idClasse = null;
        Long idAnnee = null;
        Long idNiveau = null;
        Long idEnseignantPrincipal = null;
        String nomClasse = null;
        Integer effectifMax = null;
        String salle = null;
        String commentaire = null;

        idClasse = classe.idClasse();
        idAnnee = classe.idAnnee();
        idNiveau = classe.idNiveau();
        idEnseignantPrincipal = classe.idEnseignantPrincipal();
        nomClasse = classe.nomClasse();
        effectifMax = classe.effectifMax();
        salle = classe.salle();
        commentaire = classe.commentaire();

        ClasseDTO classeDTO = new ClasseDTO( idClasse, idAnnee, idNiveau, idEnseignantPrincipal, nomClasse, effectifMax, salle, commentaire );

        return classeDTO;
    }

    @Override
    public Classe toDomain(ClasseDTO classeDTO) {
        if ( classeDTO == null ) {
            return null;
        }

        Long idClasse = null;
        Long idAnnee = null;
        Long idNiveau = null;
        Long idEnseignantPrincipal = null;
        String nomClasse = null;
        Integer effectifMax = null;
        String salle = null;
        String commentaire = null;

        idClasse = classeDTO.idClasse();
        idAnnee = classeDTO.idAnnee();
        idNiveau = classeDTO.idNiveau();
        idEnseignantPrincipal = classeDTO.idEnseignantPrincipal();
        nomClasse = classeDTO.nomClasse();
        effectifMax = classeDTO.effectifMax();
        salle = classeDTO.salle();
        commentaire = classeDTO.commentaire();

        Classe classe = new Classe( idClasse, idAnnee, idNiveau, idEnseignantPrincipal, nomClasse, effectifMax, salle, commentaire );

        return classe;
    }

    @Override
    public MatiereDTO toDto(Matiere matiere) {
        if ( matiere == null ) {
            return null;
        }

        Long idMatiere = null;
        String code = null;
        String libelle = null;
        String description = null;
        Double coefficient = null;
        String couleur = null;
        Boolean actif = null;

        idMatiere = matiere.idMatiere();
        code = matiere.code();
        libelle = matiere.libelle();
        description = matiere.description();
        coefficient = matiere.coefficient();
        couleur = matiere.couleur();
        actif = matiere.actif();

        MatiereDTO matiereDTO = new MatiereDTO( idMatiere, code, libelle, description, coefficient, couleur, actif );

        return matiereDTO;
    }

    @Override
    public Matiere toDomain(MatiereDTO matiereDTO) {
        if ( matiereDTO == null ) {
            return null;
        }

        Long idMatiere = null;
        String code = null;
        String libelle = null;
        String description = null;
        Double coefficient = null;
        String couleur = null;
        Boolean actif = null;

        idMatiere = matiereDTO.idMatiere();
        code = matiereDTO.code();
        libelle = matiereDTO.libelle();
        description = matiereDTO.description();
        coefficient = matiereDTO.coefficient();
        couleur = matiereDTO.couleur();
        actif = matiereDTO.actif();

        Matiere matiere = new Matiere( idMatiere, code, libelle, description, coefficient, couleur, actif );

        return matiere;
    }

    @Override
    public CoursDTO toDto(Cours cours) {
        if ( cours == null ) {
            return null;
        }

        Long idCours = null;
        Long idClasse = null;
        Long idMatiere = null;
        Long idEnseignant = null;
        Long idAnnee = null;
        Double heuresSemaine = null;
        Double coefficient = null;
        String salle = null;

        idCours = cours.idCours();
        idClasse = cours.idClasse();
        idMatiere = cours.idMatiere();
        idEnseignant = cours.idEnseignant();
        idAnnee = cours.idAnnee();
        heuresSemaine = cours.heuresSemaine();
        coefficient = cours.coefficient();
        salle = cours.salle();

        CoursDTO coursDTO = new CoursDTO( idCours, idClasse, idMatiere, idEnseignant, idAnnee, heuresSemaine, coefficient, salle );

        return coursDTO;
    }

    @Override
    public Cours toDomain(CoursDTO coursDTO) {
        if ( coursDTO == null ) {
            return null;
        }

        Long idCours = null;
        Long idClasse = null;
        Long idMatiere = null;
        Long idEnseignant = null;
        Long idAnnee = null;
        Double heuresSemaine = null;
        Double coefficient = null;
        String salle = null;

        idCours = coursDTO.idCours();
        idClasse = coursDTO.idClasse();
        idMatiere = coursDTO.idMatiere();
        idEnseignant = coursDTO.idEnseignant();
        idAnnee = coursDTO.idAnnee();
        heuresSemaine = coursDTO.heuresSemaine();
        coefficient = coursDTO.coefficient();
        salle = coursDTO.salle();

        Cours cours = new Cours( idCours, idClasse, idMatiere, idEnseignant, idAnnee, heuresSemaine, coefficient, salle );

        return cours;
    }

    @Override
    public HoraireCoursDTO toDto(HoraireCours horaireCours) {
        if ( horaireCours == null ) {
            return null;
        }

        Long idHoraire = null;
        Long idCours = null;
        String jourSemaine = null;
        LocalTime heureDebut = null;
        LocalTime heureFin = null;
        String salle = null;

        idHoraire = horaireCours.idHoraire();
        idCours = horaireCours.idCours();
        jourSemaine = horaireCours.jourSemaine();
        heureDebut = horaireCours.heureDebut();
        heureFin = horaireCours.heureFin();
        salle = horaireCours.salle();

        HoraireCoursDTO horaireCoursDTO = new HoraireCoursDTO( idHoraire, idCours, jourSemaine, heureDebut, heureFin, salle );

        return horaireCoursDTO;
    }

    @Override
    public HoraireCours toDomain(HoraireCoursDTO horaireCoursDTO) {
        if ( horaireCoursDTO == null ) {
            return null;
        }

        Long idHoraire = null;
        Long idCours = null;
        String jourSemaine = null;
        LocalTime heureDebut = null;
        LocalTime heureFin = null;
        String salle = null;

        idHoraire = horaireCoursDTO.idHoraire();
        idCours = horaireCoursDTO.idCours();
        jourSemaine = horaireCoursDTO.jourSemaine();
        heureDebut = horaireCoursDTO.heureDebut();
        heureFin = horaireCoursDTO.heureFin();
        salle = horaireCoursDTO.salle();

        HoraireCours horaireCours = new HoraireCours( idHoraire, idCours, jourSemaine, heureDebut, heureFin, salle );

        return horaireCours;
    }

    @Override
    public InscriptionDTO toDto(Inscription inscription) {
        if ( inscription == null ) {
            return null;
        }

        Long idInscription = null;
        Long idEleve = null;
        Long idClasse = null;
        LocalDate dateInscription = null;
        LocalDate dateFin = null;
        String statut = null;
        String commentaire = null;

        idInscription = inscription.idInscription();
        idEleve = inscription.idEleve();
        idClasse = inscription.idClasse();
        dateInscription = inscription.dateInscription();
        dateFin = inscription.dateFin();
        statut = inscription.statut();
        commentaire = inscription.commentaire();

        InscriptionDTO inscriptionDTO = new InscriptionDTO( idInscription, idEleve, idClasse, dateInscription, dateFin, statut, commentaire );

        return inscriptionDTO;
    }

    @Override
    public Inscription toDomain(InscriptionDTO inscriptionDTO) {
        if ( inscriptionDTO == null ) {
            return null;
        }

        Long idInscription = null;
        Long idEleve = null;
        Long idClasse = null;
        LocalDate dateInscription = null;
        LocalDate dateFin = null;
        String statut = null;
        String commentaire = null;

        idInscription = inscriptionDTO.idInscription();
        idEleve = inscriptionDTO.idEleve();
        idClasse = inscriptionDTO.idClasse();
        dateInscription = inscriptionDTO.dateInscription();
        dateFin = inscriptionDTO.dateFin();
        statut = inscriptionDTO.statut();
        commentaire = inscriptionDTO.commentaire();

        Inscription inscription = new Inscription( idInscription, idEleve, idClasse, dateInscription, dateFin, statut, commentaire );

        return inscription;
    }

    @Override
    public PeriodeDTO toDto(Periode periode) {
        if ( periode == null ) {
            return null;
        }

        Long idPeriode = null;
        Long idAnnee = null;
        String libelle = null;
        Integer numeroPeriode = null;
        LocalDate dateDebut = null;
        LocalDate dateFin = null;
        Boolean cloturee = null;

        idPeriode = periode.idPeriode();
        idAnnee = periode.idAnnee();
        libelle = periode.libelle();
        numeroPeriode = periode.numeroPeriode();
        dateDebut = periode.dateDebut();
        dateFin = periode.dateFin();
        cloturee = periode.cloturee();

        PeriodeDTO periodeDTO = new PeriodeDTO( idPeriode, idAnnee, libelle, numeroPeriode, dateDebut, dateFin, cloturee );

        return periodeDTO;
    }

    @Override
    public Periode toDomain(PeriodeDTO periodeDTO) {
        if ( periodeDTO == null ) {
            return null;
        }

        Long idPeriode = null;
        Long idAnnee = null;
        String libelle = null;
        Integer numeroPeriode = null;
        LocalDate dateDebut = null;
        LocalDate dateFin = null;
        Boolean cloturee = null;

        idPeriode = periodeDTO.idPeriode();
        idAnnee = periodeDTO.idAnnee();
        libelle = periodeDTO.libelle();
        numeroPeriode = periodeDTO.numeroPeriode();
        dateDebut = periodeDTO.dateDebut();
        dateFin = periodeDTO.dateFin();
        cloturee = periodeDTO.cloturee();

        Periode periode = new Periode( idPeriode, idAnnee, libelle, numeroPeriode, dateDebut, dateFin, cloturee );

        return periode;
    }

    @Override
    public TypeEvaluationDTO toDto(TypeEvaluation typeEvaluation) {
        if ( typeEvaluation == null ) {
            return null;
        }

        Long idTypeEval = null;
        String code = null;
        String libelle = null;
        Double coefficient = null;
        Boolean compteMoyenne = null;
        String description = null;

        idTypeEval = typeEvaluation.idTypeEval();
        code = typeEvaluation.code();
        libelle = typeEvaluation.libelle();
        coefficient = typeEvaluation.coefficient();
        compteMoyenne = typeEvaluation.compteMoyenne();
        description = typeEvaluation.description();

        TypeEvaluationDTO typeEvaluationDTO = new TypeEvaluationDTO( idTypeEval, code, libelle, coefficient, compteMoyenne, description );

        return typeEvaluationDTO;
    }

    @Override
    public TypeEvaluation toDomain(TypeEvaluationDTO typeEvaluationDTO) {
        if ( typeEvaluationDTO == null ) {
            return null;
        }

        Long idTypeEval = null;
        String code = null;
        String libelle = null;
        Double coefficient = null;
        Boolean compteMoyenne = null;
        String description = null;

        idTypeEval = typeEvaluationDTO.idTypeEval();
        code = typeEvaluationDTO.code();
        libelle = typeEvaluationDTO.libelle();
        coefficient = typeEvaluationDTO.coefficient();
        compteMoyenne = typeEvaluationDTO.compteMoyenne();
        description = typeEvaluationDTO.description();

        TypeEvaluation typeEvaluation = new TypeEvaluation( idTypeEval, code, libelle, coefficient, compteMoyenne, description );

        return typeEvaluation;
    }

    @Override
    public EvaluationDTO toDto(Evaluation evaluation) {
        if ( evaluation == null ) {
            return null;
        }

        Long idEvaluation = null;
        Long idCours = null;
        Long idPeriode = null;
        Long idTypeEval = null;
        String intitule = null;
        LocalDate dateEvaluation = null;
        Double noteSur = null;
        Double coefficient = null;
        Integer dureeMinutes = null;
        String commentaire = null;
        LocalDateTime dateCreation = null;

        idEvaluation = evaluation.idEvaluation();
        idCours = evaluation.idCours();
        idPeriode = evaluation.idPeriode();
        idTypeEval = evaluation.idTypeEval();
        intitule = evaluation.intitule();
        dateEvaluation = evaluation.dateEvaluation();
        noteSur = evaluation.noteSur();
        coefficient = evaluation.coefficient();
        dureeMinutes = evaluation.dureeMinutes();
        commentaire = evaluation.commentaire();
        dateCreation = evaluation.dateCreation();

        EvaluationDTO evaluationDTO = new EvaluationDTO( idEvaluation, idCours, idPeriode, idTypeEval, intitule, dateEvaluation, noteSur, coefficient, dureeMinutes, commentaire, dateCreation );

        return evaluationDTO;
    }

    @Override
    public Evaluation toDomain(EvaluationDTO evaluationDTO) {
        if ( evaluationDTO == null ) {
            return null;
        }

        Long idEvaluation = null;
        Long idCours = null;
        Long idPeriode = null;
        Long idTypeEval = null;
        String intitule = null;
        LocalDate dateEvaluation = null;
        Double noteSur = null;
        Double coefficient = null;
        Integer dureeMinutes = null;
        String commentaire = null;
        LocalDateTime dateCreation = null;

        idEvaluation = evaluationDTO.idEvaluation();
        idCours = evaluationDTO.idCours();
        idPeriode = evaluationDTO.idPeriode();
        idTypeEval = evaluationDTO.idTypeEval();
        intitule = evaluationDTO.intitule();
        dateEvaluation = evaluationDTO.dateEvaluation();
        noteSur = evaluationDTO.noteSur();
        coefficient = evaluationDTO.coefficient();
        dureeMinutes = evaluationDTO.dureeMinutes();
        commentaire = evaluationDTO.commentaire();
        dateCreation = evaluationDTO.dateCreation();

        Evaluation evaluation = new Evaluation( idEvaluation, idCours, idPeriode, idTypeEval, intitule, dateEvaluation, noteSur, coefficient, dureeMinutes, commentaire, dateCreation );

        return evaluation;
    }

    @Override
    public NoteDTO toDto(Note note) {
        if ( note == null ) {
            return null;
        }

        Long idNote = null;
        Long idEvaluation = null;
        Long idEleve = null;
        Double valeur = null;
        Boolean absent = null;
        Boolean dispense = null;
        String appreciation = null;
        LocalDateTime dateSaisie = null;
        LocalDateTime dateModification = null;

        idNote = note.idNote();
        idEvaluation = note.idEvaluation();
        idEleve = note.idEleve();
        valeur = note.valeur();
        absent = note.absent();
        dispense = note.dispense();
        appreciation = note.appreciation();
        dateSaisie = note.dateSaisie();
        dateModification = note.dateModification();

        NoteDTO noteDTO = new NoteDTO( idNote, idEvaluation, idEleve, valeur, absent, dispense, appreciation, dateSaisie, dateModification );

        return noteDTO;
    }

    @Override
    public Note toDomain(NoteDTO noteDTO) {
        if ( noteDTO == null ) {
            return null;
        }

        Long idNote = null;
        Long idEvaluation = null;
        Long idEleve = null;
        Double valeur = null;
        Boolean absent = null;
        Boolean dispense = null;
        String appreciation = null;
        LocalDateTime dateSaisie = null;
        LocalDateTime dateModification = null;

        idNote = noteDTO.idNote();
        idEvaluation = noteDTO.idEvaluation();
        idEleve = noteDTO.idEleve();
        valeur = noteDTO.valeur();
        absent = noteDTO.absent();
        dispense = noteDTO.dispense();
        appreciation = noteDTO.appreciation();
        dateSaisie = noteDTO.dateSaisie();
        dateModification = noteDTO.dateModification();

        Note note = new Note( idNote, idEvaluation, idEleve, valeur, absent, dispense, appreciation, dateSaisie, dateModification );

        return note;
    }

    @Override
    public AbsenceDTO toDto(Absence absence) {
        if ( absence == null ) {
            return null;
        }

        Long idAbsence = null;
        Long idEleve = null;
        Long idCours = null;
        LocalDate dateAbsence = null;
        LocalTime heureDebut = null;
        LocalTime heureFin = null;
        Boolean justifie = null;
        String motif = null;
        String pieceJustificative = null;
        String commentaire = null;
        LocalDateTime dateSaisie = null;

        idAbsence = absence.idAbsence();
        idEleve = absence.idEleve();
        idCours = absence.idCours();
        dateAbsence = absence.dateAbsence();
        heureDebut = absence.heureDebut();
        heureFin = absence.heureFin();
        justifie = absence.justifie();
        motif = absence.motif();
        pieceJustificative = absence.pieceJustificative();
        commentaire = absence.commentaire();
        dateSaisie = absence.dateSaisie();

        AbsenceDTO absenceDTO = new AbsenceDTO( idAbsence, idEleve, idCours, dateAbsence, heureDebut, heureFin, justifie, motif, pieceJustificative, commentaire, dateSaisie );

        return absenceDTO;
    }

    @Override
    public Absence toDomain(AbsenceDTO absenceDTO) {
        if ( absenceDTO == null ) {
            return null;
        }

        Long idAbsence = null;
        Long idEleve = null;
        Long idCours = null;
        LocalDate dateAbsence = null;
        LocalTime heureDebut = null;
        LocalTime heureFin = null;
        Boolean justifie = null;
        String motif = null;
        String pieceJustificative = null;
        String commentaire = null;
        LocalDateTime dateSaisie = null;

        idAbsence = absenceDTO.idAbsence();
        idEleve = absenceDTO.idEleve();
        idCours = absenceDTO.idCours();
        dateAbsence = absenceDTO.dateAbsence();
        heureDebut = absenceDTO.heureDebut();
        heureFin = absenceDTO.heureFin();
        justifie = absenceDTO.justifie();
        motif = absenceDTO.motif();
        pieceJustificative = absenceDTO.pieceJustificative();
        commentaire = absenceDTO.commentaire();
        dateSaisie = absenceDTO.dateSaisie();

        Absence absence = new Absence( idAbsence, idEleve, idCours, dateAbsence, heureDebut, heureFin, justifie, motif, pieceJustificative, commentaire, dateSaisie );

        return absence;
    }

    @Override
    public RetardDTO toDto(Retard retard) {
        if ( retard == null ) {
            return null;
        }

        Long idRetard = null;
        Long idEleve = null;
        Long idCours = null;
        LocalDate dateRetard = null;
        LocalTime heureArrivee = null;
        Integer dureeMinutes = null;
        Boolean justifie = null;
        String motif = null;

        idRetard = retard.idRetard();
        idEleve = retard.idEleve();
        idCours = retard.idCours();
        dateRetard = retard.dateRetard();
        heureArrivee = retard.heureArrivee();
        dureeMinutes = retard.dureeMinutes();
        justifie = retard.justifie();
        motif = retard.motif();

        RetardDTO retardDTO = new RetardDTO( idRetard, idEleve, idCours, dateRetard, heureArrivee, dureeMinutes, justifie, motif );

        return retardDTO;
    }

    @Override
    public Retard toDomain(RetardDTO retardDTO) {
        if ( retardDTO == null ) {
            return null;
        }

        Long idRetard = null;
        Long idEleve = null;
        Long idCours = null;
        LocalDate dateRetard = null;
        LocalTime heureArrivee = null;
        Integer dureeMinutes = null;
        Boolean justifie = null;
        String motif = null;

        idRetard = retardDTO.idRetard();
        idEleve = retardDTO.idEleve();
        idCours = retardDTO.idCours();
        dateRetard = retardDTO.dateRetard();
        heureArrivee = retardDTO.heureArrivee();
        dureeMinutes = retardDTO.dureeMinutes();
        justifie = retardDTO.justifie();
        motif = retardDTO.motif();

        Retard retard = new Retard( idRetard, idEleve, idCours, dateRetard, heureArrivee, dureeMinutes, justifie, motif );

        return retard;
    }

    @Override
    public BulletinDTO toDto(Bulletin bulletin) {
        if ( bulletin == null ) {
            return null;
        }

        Long idBulletin = null;
        Long idEleve = null;
        Long idClasse = null;
        Long idPeriode = null;
        Double moyenneGenerale = null;
        Integer rang = null;
        Integer totalEleves = null;
        Integer nbAbsences = null;
        Integer nbRetards = null;
        String appreciationGenerale = null;
        String decisionConseil = null;
        LocalDate dateConseil = null;
        LocalDateTime dateGeneration = null;
        Boolean valide = null;
        LocalDateTime dateValidation = null;

        idBulletin = bulletin.idBulletin();
        idEleve = bulletin.idEleve();
        idClasse = bulletin.idClasse();
        idPeriode = bulletin.idPeriode();
        moyenneGenerale = bulletin.moyenneGenerale();
        rang = bulletin.rang();
        totalEleves = bulletin.totalEleves();
        nbAbsences = bulletin.nbAbsences();
        nbRetards = bulletin.nbRetards();
        appreciationGenerale = bulletin.appreciationGenerale();
        decisionConseil = bulletin.decisionConseil();
        dateConseil = bulletin.dateConseil();
        dateGeneration = bulletin.dateGeneration();
        valide = bulletin.valide();
        dateValidation = bulletin.dateValidation();

        BulletinDTO bulletinDTO = new BulletinDTO( idBulletin, idEleve, idClasse, idPeriode, moyenneGenerale, rang, totalEleves, nbAbsences, nbRetards, appreciationGenerale, decisionConseil, dateConseil, dateGeneration, valide, dateValidation );

        return bulletinDTO;
    }

    @Override
    public Bulletin toDomain(BulletinDTO bulletinDTO) {
        if ( bulletinDTO == null ) {
            return null;
        }

        Long idBulletin = null;
        Long idEleve = null;
        Long idClasse = null;
        Long idPeriode = null;
        Double moyenneGenerale = null;
        Integer rang = null;
        Integer totalEleves = null;
        Integer nbAbsences = null;
        Integer nbRetards = null;
        String appreciationGenerale = null;
        String decisionConseil = null;
        LocalDate dateConseil = null;
        LocalDateTime dateGeneration = null;
        Boolean valide = null;
        LocalDateTime dateValidation = null;

        idBulletin = bulletinDTO.idBulletin();
        idEleve = bulletinDTO.idEleve();
        idClasse = bulletinDTO.idClasse();
        idPeriode = bulletinDTO.idPeriode();
        moyenneGenerale = bulletinDTO.moyenneGenerale();
        rang = bulletinDTO.rang();
        totalEleves = bulletinDTO.totalEleves();
        nbAbsences = bulletinDTO.nbAbsences();
        nbRetards = bulletinDTO.nbRetards();
        appreciationGenerale = bulletinDTO.appreciationGenerale();
        decisionConseil = bulletinDTO.decisionConseil();
        dateConseil = bulletinDTO.dateConseil();
        dateGeneration = bulletinDTO.dateGeneration();
        valide = bulletinDTO.valide();
        dateValidation = bulletinDTO.dateValidation();

        Bulletin bulletin = new Bulletin( idBulletin, idEleve, idClasse, idPeriode, moyenneGenerale, rang, totalEleves, nbAbsences, nbRetards, appreciationGenerale, decisionConseil, dateConseil, dateGeneration, valide, dateValidation );

        return bulletin;
    }

    @Override
    public BulletinDetailDTO toDto(BulletinDetail bulletinDetail) {
        if ( bulletinDetail == null ) {
            return null;
        }

        Long idBulletinDetail = null;
        Long idBulletin = null;
        Long idMatiere = null;
        Double moyenne = null;
        Double coefficient = null;
        Integer rang = null;
        Double moyenneClasse = null;
        Double noteMin = null;
        Double noteMax = null;
        String appreciation = null;

        idBulletinDetail = bulletinDetail.idBulletinDetail();
        idBulletin = bulletinDetail.idBulletin();
        idMatiere = bulletinDetail.idMatiere();
        moyenne = bulletinDetail.moyenne();
        coefficient = bulletinDetail.coefficient();
        rang = bulletinDetail.rang();
        moyenneClasse = bulletinDetail.moyenneClasse();
        noteMin = bulletinDetail.noteMin();
        noteMax = bulletinDetail.noteMax();
        appreciation = bulletinDetail.appreciation();

        BulletinDetailDTO bulletinDetailDTO = new BulletinDetailDTO( idBulletinDetail, idBulletin, idMatiere, moyenne, coefficient, rang, moyenneClasse, noteMin, noteMax, appreciation );

        return bulletinDetailDTO;
    }

    @Override
    public BulletinDetail toDomain(BulletinDetailDTO bulletinDetailDTO) {
        if ( bulletinDetailDTO == null ) {
            return null;
        }

        Long idBulletinDetail = null;
        Long idBulletin = null;
        Long idMatiere = null;
        Double moyenne = null;
        Double coefficient = null;
        Integer rang = null;
        Double moyenneClasse = null;
        Double noteMin = null;
        Double noteMax = null;
        String appreciation = null;

        idBulletinDetail = bulletinDetailDTO.idBulletinDetail();
        idBulletin = bulletinDetailDTO.idBulletin();
        idMatiere = bulletinDetailDTO.idMatiere();
        moyenne = bulletinDetailDTO.moyenne();
        coefficient = bulletinDetailDTO.coefficient();
        rang = bulletinDetailDTO.rang();
        moyenneClasse = bulletinDetailDTO.moyenneClasse();
        noteMin = bulletinDetailDTO.noteMin();
        noteMax = bulletinDetailDTO.noteMax();
        appreciation = bulletinDetailDTO.appreciation();

        BulletinDetail bulletinDetail = new BulletinDetail( idBulletinDetail, idBulletin, idMatiere, moyenne, coefficient, rang, moyenneClasse, noteMin, noteMax, appreciation );

        return bulletinDetail;
    }
}
