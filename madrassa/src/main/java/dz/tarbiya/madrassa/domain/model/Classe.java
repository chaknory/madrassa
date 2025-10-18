package dz.tarbiya.madrassa.domain.model;

public record Classe(
    Long idClasse,
    Long idAnnee,
    Long idNiveau,
    Long idEnseignantPrincipal,
    String nomClasse,
    Integer effectifMax,
    String salle,
    String commentaire
) {}
