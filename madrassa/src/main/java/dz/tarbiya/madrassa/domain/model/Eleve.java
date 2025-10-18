package dz.tarbiya.madrassa.domain.model;

import java.time.LocalDate;

public record Eleve(
    Long id,
    String nom,
    String prenom,
    LocalDate dateNaissance,
    String numeroEleve
    // ... autres champs utiles
) {}
