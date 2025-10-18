package dz.tarbiya.madrassa.adapter.in.rest.dto;

public record BulletinDetailDTO(
    Long idBulletinDetail,
    Long idBulletin,
    Long idMatiere,
    Double moyenne,
    Double coefficient,
    Integer rang,
    Double moyenneClasse,
    Double noteMin,
    Double noteMax,
    String appreciation
) {}