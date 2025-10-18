package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Inscription;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:30+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class InscriptionDtoMapperImpl implements InscriptionDtoMapper {

    @Override
    public InscriptionDTO toDto(Inscription inscription) {
        if ( inscription == null ) {
            return null;
        }

        Long idInscription = null;
        Long idEleve = null;
        Long idClasse = null;
        LocalDate dateInscription = null;
        LocalDate dateFin = null;
        String statut = null;
        String commentaire = null;

        idInscription = inscription.idInscription();
        idEleve = inscription.idEleve();
        idClasse = inscription.idClasse();
        dateInscription = inscription.dateInscription();
        dateFin = inscription.dateFin();
        statut = inscription.statut();
        commentaire = inscription.commentaire();

        InscriptionDTO inscriptionDTO = new InscriptionDTO( idInscription, idEleve, idClasse, dateInscription, dateFin, statut, commentaire );

        return inscriptionDTO;
    }

    @Override
    public Inscription toDomain(InscriptionDTO inscriptionDTO) {
        if ( inscriptionDTO == null ) {
            return null;
        }

        Long idInscription = null;
        Long idEleve = null;
        Long idClasse = null;
        LocalDate dateInscription = null;
        LocalDate dateFin = null;
        String statut = null;
        String commentaire = null;

        idInscription = inscriptionDTO.idInscription();
        idEleve = inscriptionDTO.idEleve();
        idClasse = inscriptionDTO.idClasse();
        dateInscription = inscriptionDTO.dateInscription();
        dateFin = inscriptionDTO.dateFin();
        statut = inscriptionDTO.statut();
        commentaire = inscriptionDTO.commentaire();

        Inscription inscription = new Inscription( idInscription, idEleve, idClasse, dateInscription, dateFin, statut, commentaire );

        return inscription;
    }
}
