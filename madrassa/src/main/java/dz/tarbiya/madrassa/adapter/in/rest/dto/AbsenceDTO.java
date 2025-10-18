package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public record AbsenceDTO(
    Long idAbsence,
    Long idEleve,
    Long idCours,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateAbsence,
    @JsonFormat(pattern = "HH:mm")
    LocalTime heureDebut,
    @JsonFormat(pattern = "HH:mm")
    LocalTime heureFin,
    Boolean justifie,
    String motif,
    String pieceJustificative,
    String commentaire,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateSaisie
) {}