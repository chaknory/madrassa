package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public record EnseignantDTO(
    Long idEnseignant,
    Long idPersonne,
    String numeroEmploye,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateEmbauche,
    String specialite,
    String diplome,
    String statut,
    Double volumeHoraireHebdo,
    Boolean actif
) {}