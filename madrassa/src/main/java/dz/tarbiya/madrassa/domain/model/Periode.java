package dz.tarbiya.madrassa.domain.model;
import java.time.LocalDate;

public record Periode(
    Long idPeriode,
    Long idAnnee,
    String libelle,
    Integer numeroPeriode,
    LocalDate dateDebut,
    LocalDate dateFin,
    Boolean cloturee
) {}
