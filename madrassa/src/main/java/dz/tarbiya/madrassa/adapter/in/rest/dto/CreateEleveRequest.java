package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * DTO pour créer un nouvel élève
 */
public record CreateEleveRequest(
    @NotBlank(message = "Le nom est obligatoire")
    String nom,
    
    @NotBlank(message = "Le prénom est obligatoire")
    String prenom,
    
    @NotNull(message = "La date de naissance est obligatoire")
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateNaissance,
    
    String numeroEleve
) {}