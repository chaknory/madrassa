package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Absence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:30+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class AbsenceDtoMapperImpl implements AbsenceDtoMapper {

    @Override
    public AbsenceDTO toDto(Absence absence) {
        if ( absence == null ) {
            return null;
        }

        Long idAbsence = null;
        Long idEleve = null;
        Long idCours = null;
        LocalDate dateAbsence = null;
        LocalTime heureDebut = null;
        LocalTime heureFin = null;
        Boolean justifie = null;
        String motif = null;
        String pieceJustificative = null;
        String commentaire = null;
        LocalDateTime dateSaisie = null;

        idAbsence = absence.idAbsence();
        idEleve = absence.idEleve();
        idCours = absence.idCours();
        dateAbsence = absence.dateAbsence();
        heureDebut = absence.heureDebut();
        heureFin = absence.heureFin();
        justifie = absence.justifie();
        motif = absence.motif();
        pieceJustificative = absence.pieceJustificative();
        commentaire = absence.commentaire();
        dateSaisie = absence.dateSaisie();

        AbsenceDTO absenceDTO = new AbsenceDTO( idAbsence, idEleve, idCours, dateAbsence, heureDebut, heureFin, justifie, motif, pieceJustificative, commentaire, dateSaisie );

        return absenceDTO;
    }

    @Override
    public Absence toDomain(AbsenceDTO absenceDTO) {
        if ( absenceDTO == null ) {
            return null;
        }

        Long idAbsence = null;
        Long idEleve = null;
        Long idCours = null;
        LocalDate dateAbsence = null;
        LocalTime heureDebut = null;
        LocalTime heureFin = null;
        Boolean justifie = null;
        String motif = null;
        String pieceJustificative = null;
        String commentaire = null;
        LocalDateTime dateSaisie = null;

        idAbsence = absenceDTO.idAbsence();
        idEleve = absenceDTO.idEleve();
        idCours = absenceDTO.idCours();
        dateAbsence = absenceDTO.dateAbsence();
        heureDebut = absenceDTO.heureDebut();
        heureFin = absenceDTO.heureFin();
        justifie = absenceDTO.justifie();
        motif = absenceDTO.motif();
        pieceJustificative = absenceDTO.pieceJustificative();
        commentaire = absenceDTO.commentaire();
        dateSaisie = absenceDTO.dateSaisie();

        Absence absence = new Absence( idAbsence, idEleve, idCours, dateAbsence, heureDebut, heureFin, justifie, motif, pieceJustificative, commentaire, dateSaisie );

        return absence;
    }
}
