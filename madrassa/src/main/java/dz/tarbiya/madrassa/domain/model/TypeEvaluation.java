package dz.tarbiya.madrassa.domain.model;

public record TypeEvaluation(
    Long idTypeEval,
    String code,
    String libelle,
    Double coefficient,
    Boolean compteMoyenne,
    String description
) {}
