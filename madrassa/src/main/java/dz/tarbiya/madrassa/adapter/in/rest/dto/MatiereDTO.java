package dz.tarbiya.madrassa.adapter.in.rest.dto;

public record MatiereDTO(
    Long idMatiere,
    String code,
    String libelle,
    String description,
    Double coefficient,
    String couleur,
    Boolean actif
) {}