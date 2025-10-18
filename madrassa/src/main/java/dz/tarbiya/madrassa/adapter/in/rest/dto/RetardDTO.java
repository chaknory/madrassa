package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public record RetardDTO(
    Long idRetard,
    Long idEleve,
    Long idCours,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateRetard,
    @JsonFormat(pattern = "HH:mm")
    LocalTime heureArrivee,
    Integer dureeMinutes,
    Boolean justifie,
    String motif
) {}