package dz.tarbiya.madrassa.domain.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record Personne(
    Long idPersonne,
    String nom,
    String prenom,
    LocalDate dateNaissance,
    String sexe,
    String email,
    String telephone,
    String telephoneMobile,
    String adresse,
    String codePostal,
    String ville,
    String pays,
    String photoUrl,
    String typePersonne,
    Boolean actif,
    LocalDateTime dateCreation,
    LocalDateTime dateModification
) {}
