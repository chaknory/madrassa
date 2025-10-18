package dz.tarbiya.madrassa.domain.model;
import java.time.LocalDate;
import java.time.LocalTime;

public record Retard(
    Long idRetard,
    Long idEleve,
    Long idCours,
    LocalDate dateRetard,
    LocalTime heureArrivee,
    Integer dureeMinutes,
    Boolean justifie,
    String motif
) {}
