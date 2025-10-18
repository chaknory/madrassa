package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Cours;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:29+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class CoursDtoMapperImpl implements CoursDtoMapper {

    @Override
    public CoursDTO toDto(Cours cours) {
        if ( cours == null ) {
            return null;
        }

        Long idCours = null;
        Long idClasse = null;
        Long idMatiere = null;
        Long idEnseignant = null;
        Long idAnnee = null;
        Double heuresSemaine = null;
        Double coefficient = null;
        String salle = null;

        idCours = cours.idCours();
        idClasse = cours.idClasse();
        idMatiere = cours.idMatiere();
        idEnseignant = cours.idEnseignant();
        idAnnee = cours.idAnnee();
        heuresSemaine = cours.heuresSemaine();
        coefficient = cours.coefficient();
        salle = cours.salle();

        CoursDTO coursDTO = new CoursDTO( idCours, idClasse, idMatiere, idEnseignant, idAnnee, heuresSemaine, coefficient, salle );

        return coursDTO;
    }

    @Override
    public Cours toDomain(CoursDTO coursDTO) {
        if ( coursDTO == null ) {
            return null;
        }

        Long idCours = null;
        Long idClasse = null;
        Long idMatiere = null;
        Long idEnseignant = null;
        Long idAnnee = null;
        Double heuresSemaine = null;
        Double coefficient = null;
        String salle = null;

        idCours = coursDTO.idCours();
        idClasse = coursDTO.idClasse();
        idMatiere = coursDTO.idMatiere();
        idEnseignant = coursDTO.idEnseignant();
        idAnnee = coursDTO.idAnnee();
        heuresSemaine = coursDTO.heuresSemaine();
        coefficient = coursDTO.coefficient();
        salle = coursDTO.salle();

        Cours cours = new Cours( idCours, idClasse, idMatiere, idEnseignant, idAnnee, heuresSemaine, coefficient, salle );

        return cours;
    }
}
