package dz.tarbiya.madrassa.domain.model;
import java.time.LocalTime;
import java.time.LocalDate;

public record HoraireCours(
    Long idHoraire,
    Long idCours,
    String jourSemaine,
    LocalTime heureDebut,
    LocalTime heureFin,
    String salle
) {}
