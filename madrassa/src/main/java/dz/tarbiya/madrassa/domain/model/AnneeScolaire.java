package dz.tarbiya.madrassa.domain.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record AnneeScolaire(
    Long idAnnee,
    String libelle,
    LocalDate dateDebut,
    LocalDate dateFin,
    Boolean active
) {}
