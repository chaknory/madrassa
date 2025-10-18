package dz.tarbiya.madrassa.domain.model;

public record Cours(
    Long idCours,
    Long idClasse,
    Long idMatiere,
    Long idEnseignant,
    Long idAnnee,
    Double heuresSemaine,
    Double coefficient,
    String salle
) {}
