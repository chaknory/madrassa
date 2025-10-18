package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record ResponsableLegalDTO(
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateCreation
) {}