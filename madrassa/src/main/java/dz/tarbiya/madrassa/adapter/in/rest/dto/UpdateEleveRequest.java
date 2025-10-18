package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * DTO pour mettre à jour un élève
 */
public record UpdateEleveRequest(
    @NotBlank(message = "Le nom est obligatoire")
    String nom,
    
    @NotBlank(message = "Le prénom est obligatoire")
    String prenom,
    
    @NotNull(message = "La date de naissance est obligatoire")
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateNaissance,
    
    String numeroEleve
) {}