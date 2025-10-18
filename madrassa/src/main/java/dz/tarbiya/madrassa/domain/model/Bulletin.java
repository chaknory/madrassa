package dz.tarbiya.madrassa.domain.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record Bulletin(
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
    LocalDate dateConseil,
    LocalDateTime dateGeneration,
    Boolean valide,
    LocalDateTime dateValidation
) {}
