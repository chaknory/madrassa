package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record BulletinDTO(
    Long idBulletin,
    Long idEleve,
    Long idClasse,
    Long idPeriode,
    Double moyenneGenerale,
    Integer rang,
    Integer totalEleves,
    Integer nbAbsences,
    Integer nbRetards,
    String appreciationGenerale,
    String decisionConseil,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateConseil,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateGeneration,
    Boolean valide,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateValidation
) {}