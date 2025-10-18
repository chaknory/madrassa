package dz.tarbiya.madrassa.domain.model;
import java.time.LocalDate;

public record Enseignant(
    Long idEnseignant,
    Long idPersonne,
    String numeroEmploye,
    LocalDate dateEmbauche,
    String specialite,
    String diplome,
    String statut,
    Double volumeHoraireHebdo,
    Boolean actif
) {}
