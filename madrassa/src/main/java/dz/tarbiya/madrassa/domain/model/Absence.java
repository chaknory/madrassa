package dz.tarbiya.madrassa.domain.model;
import java.time.LocalDate;
import java.time.LocalTime;

public record Absence(
    Long idAbsence,
    Long idEleve,
    Long idCours,
    LocalDate dateAbsence,
    LocalTime heureDebut,
    LocalTime heureFin,
    Boolean justifie,
    String motif,
    String pieceJustificative,
    String commentaire,
    java.time.LocalDateTime dateSaisie
) {}
