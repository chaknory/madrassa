package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public record InscriptionDTO(
    Long idInscription,
    Long idEleve,
    Long idClasse,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateInscription,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateFin,
    String statut,
    String commentaire
) {}