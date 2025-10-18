package dz.tarbiya.madrassa.domain.model;
import java.time.LocalDateTime;

public record Note(
    Long idNote,
    Long idEvaluation,
    Long idEleve,
    Double valeur,
    Boolean absent,
    Boolean dispense,
    String appreciation,
    LocalDateTime dateSaisie,
    LocalDateTime dateModification
) {}
