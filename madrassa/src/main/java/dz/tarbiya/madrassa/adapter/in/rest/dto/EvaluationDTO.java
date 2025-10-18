package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record EvaluationDTO(
    Long idEvaluation,
    Long idCours,
    Long idPeriode,
    Long idTypeEval,
    String intitule,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateEvaluation,
    Double noteSur,
    Double coefficient,
    Integer dureeMinutes,
    String commentaire,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateCreation
) {}