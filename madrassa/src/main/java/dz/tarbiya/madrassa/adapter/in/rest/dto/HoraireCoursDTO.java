package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalTime;

public record HoraireCoursDTO(
    Long idHoraire,
    Long idCours,
    String jourSemaine,
    @JsonFormat(pattern = "HH:mm")
    LocalTime heureDebut,
    @JsonFormat(pattern = "HH:mm")
    LocalTime heureFin,
    String salle
) {}