package dz.tarbiya.madrassa.adapter.in.rest.dto;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record PersonneDTO(
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
