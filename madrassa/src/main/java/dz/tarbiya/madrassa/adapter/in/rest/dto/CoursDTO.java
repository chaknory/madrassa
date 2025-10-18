package dz.tarbiya.madrassa.adapter.in.rest.dto;

public record CoursDTO(
    Long idCours,
    Long idClasse,
    Long idMatiere,
    Long idEnseignant,
    Long idAnnee,
    Double heuresSemaine,
    Double coefficient,
    String salle
) {}