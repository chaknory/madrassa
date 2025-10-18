package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public record AnneeScolaireDTO(
    Long idAnnee,
    String libelle,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateDebut,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateFin,
    Boolean active
) {}