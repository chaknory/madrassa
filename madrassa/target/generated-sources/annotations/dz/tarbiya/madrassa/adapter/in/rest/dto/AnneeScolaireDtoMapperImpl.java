package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.AnneeScolaire;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:29+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class AnneeScolaireDtoMapperImpl implements AnneeScolaireDtoMapper {

    @Override
    public AnneeScolaireDTO toDto(AnneeScolaire anneeScolaire) {
        if ( anneeScolaire == null ) {
            return null;
        }

        Long idAnnee = null;
        String libelle = null;
        LocalDate dateDebut = null;
        LocalDate dateFin = null;
        Boolean active = null;

        idAnnee = anneeScolaire.idAnnee();
        libelle = anneeScolaire.libelle();
        dateDebut = anneeScolaire.dateDebut();
        dateFin = anneeScolaire.dateFin();
        active = anneeScolaire.active();

        AnneeScolaireDTO anneeScolaireDTO = new AnneeScolaireDTO( idAnnee, libelle, dateDebut, dateFin, active );

        return anneeScolaireDTO;
    }

    @Override
    public AnneeScolaire toDomain(AnneeScolaireDTO anneeScolaireDTO) {
        if ( anneeScolaireDTO == null ) {
            return null;
        }

        Long idAnnee = null;
        String libelle = null;
        LocalDate dateDebut = null;
        LocalDate dateFin = null;
        Boolean active = null;

        idAnnee = anneeScolaireDTO.idAnnee();
        libelle = anneeScolaireDTO.libelle();
        dateDebut = anneeScolaireDTO.dateDebut();
        dateFin = anneeScolaireDTO.dateFin();
        active = anneeScolaireDTO.active();

        AnneeScolaire anneeScolaire = new AnneeScolaire( idAnnee, libelle, dateDebut, dateFin, active );

        return anneeScolaire;
    }
}
