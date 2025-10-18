package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Note;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:30+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class NoteDtoMapperImpl implements NoteDtoMapper {

    @Override
    public NoteDTO toDto(Note note) {
        if ( note == null ) {
            return null;
        }

        Long idNote = null;
        Long idEvaluation = null;
        Long idEleve = null;
        Double valeur = null;
        Boolean absent = null;
        Boolean dispense = null;
        String appreciation = null;
        LocalDateTime dateSaisie = null;
        LocalDateTime dateModification = null;

        idNote = note.idNote();
        idEvaluation = note.idEvaluation();
        idEleve = note.idEleve();
        valeur = note.valeur();
        absent = note.absent();
        dispense = note.dispense();
        appreciation = note.appreciation();
        dateSaisie = note.dateSaisie();
        dateModification = note.dateModification();

        NoteDTO noteDTO = new NoteDTO( idNote, idEvaluation, idEleve, valeur, absent, dispense, appreciation, dateSaisie, dateModification );

        return noteDTO;
    }

    @Override
    public Note toDomain(NoteDTO noteDTO) {
        if ( noteDTO == null ) {
            return null;
        }

        Long idNote = null;
        Long idEvaluation = null;
        Long idEleve = null;
        Double valeur = null;
        Boolean absent = null;
        Boolean dispense = null;
        String appreciation = null;
        LocalDateTime dateSaisie = null;
        LocalDateTime dateModification = null;

        idNote = noteDTO.idNote();
        idEvaluation = noteDTO.idEvaluation();
        idEleve = noteDTO.idEleve();
        valeur = noteDTO.valeur();
        absent = noteDTO.absent();
        dispense = noteDTO.dispense();
        appreciation = noteDTO.appreciation();
        dateSaisie = noteDTO.dateSaisie();
        dateModification = noteDTO.dateModification();

        Note note = new Note( idNote, idEvaluation, idEleve, valeur, absent, dispense, appreciation, dateSaisie, dateModification );

        return note;
    }
}
