package dz.tarbiya.madrassa.adapter.in.rest.dto;

public record ClasseDTO(
    Long idClasse,
    Long idAnnee,
    Long idNiveau,
    Long idEnseignantPrincipal,
    String nomClasse,
    Integer effectifMax,
    String salle,
    String commentaire
) {}