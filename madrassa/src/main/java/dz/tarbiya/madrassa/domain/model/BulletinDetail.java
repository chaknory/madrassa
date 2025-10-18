package dz.tarbiya.madrassa.domain.model;

public record BulletinDetail(
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
