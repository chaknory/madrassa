package dz.tarbiya.madrassa.domain.model;

public record Niveau(
    Long idNiveau,
    String code,
    String libelle,
    Integer ordre,
    String cycle
) {}
