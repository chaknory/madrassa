package dz.tarbiya.madrassa.adapter.in.rest.dto;

public record TypeEvaluationDTO(
    Long idTypeEval,
    String code,
    String libelle,
    Double coefficient,
    Boolean compteMoyenne,
    String description
) {}