package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public record EleveDTO(
    Long id,
    String nom,
    String prenom,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateNaissance,
    String numeroEleve
) {}