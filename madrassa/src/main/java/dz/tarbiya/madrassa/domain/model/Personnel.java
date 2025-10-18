package dz.tarbiya.madrassa.domain.model;
import java.time.LocalDate;

public record Personnel(
    Long idPersonnel,
    Long idPersonne,
    String numeroEmploye,
    String fonction,
    LocalDate dateEmbauche,
    String service,
    Boolean actif
) {}
