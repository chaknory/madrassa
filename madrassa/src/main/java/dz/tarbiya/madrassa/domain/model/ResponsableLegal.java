package dz.tarbiya.madrassa.domain.model;
import java.time.LocalDateTime;

public record ResponsableLegal(
    Long idResponsable,
    String nom,
    String prenom,
    String telephone,
    String telephoneMobile,
    String email,
    String adresse,
    String profession,
    String lienParente,
    Boolean contactUrgence,
    Boolean autoriseSortie,
    LocalDateTime dateCreation
) {}
