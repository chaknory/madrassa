package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Evaluation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:30+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class EvaluationDtoMapperImpl implements EvaluationDtoMapper {

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
}
