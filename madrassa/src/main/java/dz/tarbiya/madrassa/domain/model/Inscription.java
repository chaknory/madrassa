package dz.tarbiya.madrassa.domain.model;
import java.time.LocalDate;

public record Inscription(
    Long idInscription,
    Long idEleve,
    Long idClasse,
    LocalDate dateInscription,
    LocalDate dateFin,
    String statut,
    String commentaire
) {}
