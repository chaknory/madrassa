package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public record PersonnelDTO(
    Long idPersonnel,
    Long idPersonne,
    String numeroEmploye,
    String fonction,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateEmbauche,
    String service,
    Boolean actif
) {}