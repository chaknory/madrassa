package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Bulletin;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:30+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class BulletinDtoMapperImpl implements BulletinDtoMapper {

    @Override
    public BulletinDTO toDto(Bulletin bulletin) {
        if ( bulletin == null ) {
            return null;
        }

        Long idBulletin = null;
        Long idEleve = null;
        Long idClasse = null;
        Long idPeriode = null;
        Double moyenneGenerale = null;
        Integer rang = null;
        Integer totalEleves = null;
        Integer nbAbsences = null;
        Integer nbRetards = null;
        String appreciationGenerale = null;
        String decisionConseil = null;
        LocalDate dateConseil = null;
        LocalDateTime dateGeneration = null;
        Boolean valide = null;
        LocalDateTime dateValidation = null;

        idBulletin = bulletin.idBulletin();
        idEleve = bulletin.idEleve();
        idClasse = bulletin.idClasse();
        idPeriode = bulletin.idPeriode();
        moyenneGenerale = bulletin.moyenneGenerale();
        rang = bulletin.rang();
        totalEleves = bulletin.totalEleves();
        nbAbsences = bulletin.nbAbsences();
        nbRetards = bulletin.nbRetards();
        appreciationGenerale = bulletin.appreciationGenerale();
        decisionConseil = bulletin.decisionConseil();
        dateConseil = bulletin.dateConseil();
        dateGeneration = bulletin.dateGeneration();
        valide = bulletin.valide();
        dateValidation = bulletin.dateValidation();

        BulletinDTO bulletinDTO = new BulletinDTO( idBulletin, idEleve, idClasse, idPeriode, moyenneGenerale, rang, totalEleves, nbAbsences, nbRetards, appreciationGenerale, decisionConseil, dateConseil, dateGeneration, valide, dateValidation );

        return bulletinDTO;
    }

    @Override
    public Bulletin toDomain(BulletinDTO bulletinDTO) {
        if ( bulletinDTO == null ) {
            return null;
        }

        Long idBulletin = null;
        Long idEleve = null;
        Long idClasse = null;
        Long idPeriode = null;
        Double moyenneGenerale = null;
        Integer rang = null;
        Integer totalEleves = null;
        Integer nbAbsences = null;
        Integer nbRetards = null;
        String appreciationGenerale = null;
        String decisionConseil = null;
        LocalDate dateConseil = null;
        LocalDateTime dateGeneration = null;
        Boolean valide = null;
        LocalDateTime dateValidation = null;

        idBulletin = bulletinDTO.idBulletin();
        idEleve = bulletinDTO.idEleve();
        idClasse = bulletinDTO.idClasse();
        idPeriode = bulletinDTO.idPeriode();
        moyenneGenerale = bulletinDTO.moyenneGenerale();
        rang = bulletinDTO.rang();
        totalEleves = bulletinDTO.totalEleves();
        nbAbsences = bulletinDTO.nbAbsences();
        nbRetards = bulletinDTO.nbRetards();
        appreciationGenerale = bulletinDTO.appreciationGenerale();
        decisionConseil = bulletinDTO.decisionConseil();
        dateConseil = bulletinDTO.dateConseil();
        dateGeneration = bulletinDTO.dateGeneration();
        valide = bulletinDTO.valide();
        dateValidation = bulletinDTO.dateValidation();

        Bulletin bulletin = new Bulletin( idBulletin, idEleve, idClasse, idPeriode, moyenneGenerale, rang, totalEleves, nbAbsences, nbRetards, appreciationGenerale, decisionConseil, dateConseil, dateGeneration, valide, dateValidation );

        return bulletin;
    }
}
