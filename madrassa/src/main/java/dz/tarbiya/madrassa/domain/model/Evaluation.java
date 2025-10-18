package dz.tarbiya.madrassa.domain.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record Evaluation(
    Long idEvaluation,
    Long idCours,
    Long idPeriode,
    Long idTypeEval,
    String intitule,
    LocalDate dateEvaluation,
    Double noteSur,
    Double coefficient,
    Integer dureeMinutes,
    String commentaire,
    LocalDateTime dateCreation
) {}
