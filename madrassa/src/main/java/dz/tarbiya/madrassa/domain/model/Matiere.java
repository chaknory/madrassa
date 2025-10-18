package dz.tarbiya.madrassa.domain.model;

public record Matiere(
    Long idMatiere,
    String code,
    String libelle,
    String description,
    Double coefficient,
    String couleur,
    Boolean actif
) {}
