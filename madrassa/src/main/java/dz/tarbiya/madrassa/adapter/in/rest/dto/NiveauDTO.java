package dz.tarbiya.madrassa.adapter.in.rest.dto;

public record NiveauDTO(
    Long idNiveau,
    String code,
    String libelle,
    Integer ordre,
    String cycle
) {}