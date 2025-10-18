package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper global qui centralise tous les mappages DTO <-> Domain
 */
@Mapper
public interface GlobalDtoMapper {
    GlobalDtoMapper INSTANCE = Mappers.getMapper(GlobalDtoMapper.class);
    
    // Personne
    PersonneDTO toDto(Personne personne);
    Personne toDomain(PersonneDTO personneDTO);
    
    // Eleve
    EleveDTO toDto(Eleve eleve);
    Eleve toDomain(EleveDTO eleveDTO);
    
    // Enseignant
    EnseignantDTO toDto(Enseignant enseignant);
    Enseignant toDomain(EnseignantDTO enseignantDTO);
    
    // Personnel
    PersonnelDTO toDto(Personnel personnel);
    Personnel toDomain(PersonnelDTO personnelDTO);
    
    // ResponsableLegal
    ResponsableLegalDTO toDto(ResponsableLegal responsableLegal);
    ResponsableLegal toDomain(ResponsableLegalDTO responsableLegalDTO);
    
    // AnneeScolaire
    AnneeScolaireDTO toDto(AnneeScolaire anneeScolaire);
    AnneeScolaire toDomain(AnneeScolaireDTO anneeScolaireDTO);
    
    // Niveau
    NiveauDTO toDto(Niveau niveau);
    Niveau toDomain(NiveauDTO niveauDTO);
    
    // Classe
    ClasseDTO toDto(Classe classe);
    Classe toDomain(ClasseDTO classeDTO);
    
    // Matiere
    MatiereDTO toDto(Matiere matiere);
    Matiere toDomain(MatiereDTO matiereDTO);
    
    // Cours
    CoursDTO toDto(Cours cours);
    Cours toDomain(CoursDTO coursDTO);
    
    // HoraireCours
    HoraireCoursDTO toDto(HoraireCours horaireCours);
    HoraireCours toDomain(HoraireCoursDTO horaireCoursDTO);
    
    // Inscription
    InscriptionDTO toDto(Inscription inscription);
    Inscription toDomain(InscriptionDTO inscriptionDTO);
    
    // Periode
    PeriodeDTO toDto(Periode periode);
    Periode toDomain(PeriodeDTO periodeDTO);
    
    // TypeEvaluation
    TypeEvaluationDTO toDto(TypeEvaluation typeEvaluation);
    TypeEvaluation toDomain(TypeEvaluationDTO typeEvaluationDTO);
    
    // Evaluation
    EvaluationDTO toDto(Evaluation evaluation);
    Evaluation toDomain(EvaluationDTO evaluationDTO);
    
    // Note
    NoteDTO toDto(Note note);
    Note toDomain(NoteDTO noteDTO);
    
    // Absence
    AbsenceDTO toDto(Absence absence);
    Absence toDomain(AbsenceDTO absenceDTO);
    
    // Retard
    RetardDTO toDto(Retard retard);
    Retard toDomain(RetardDTO retardDTO);
    
    // Bulletin
    BulletinDTO toDto(Bulletin bulletin);
    Bulletin toDomain(BulletinDTO bulletinDTO);
    
    // BulletinDetail
    BulletinDetailDTO toDto(BulletinDetail bulletinDetail);
    BulletinDetail toDomain(BulletinDetailDTO bulletinDetailDTO);
}