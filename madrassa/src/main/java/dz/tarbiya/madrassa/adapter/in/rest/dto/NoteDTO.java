package dz.tarbiya.madrassa.adapter.in.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record NoteDTO(
    Long idNote,
    Long idEvaluation,
    Long idEleve,
    Double valeur,
    Boolean absent,
    Boolean dispense,
    String appreciation,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateSaisie,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateModification
) {}