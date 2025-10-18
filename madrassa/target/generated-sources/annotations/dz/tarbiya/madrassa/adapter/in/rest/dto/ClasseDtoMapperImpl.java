package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Classe;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:29+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class ClasseDtoMapperImpl implements ClasseDtoMapper {

    @Override
    public ClasseDTO toDto(Classe classe) {
        if ( classe == null ) {
            return null;
        }

        Long idClasse = null;
        Long idAnnee = null;
        Long idNiveau = null;
        Long idEnseignantPrincipal = null;
        String nomClasse = null;
        Integer effectifMax = null;
        String salle = null;
        String commentaire = null;

        idClasse = classe.idClasse();
        idAnnee = classe.idAnnee();
        idNiveau = classe.idNiveau();
        idEnseignantPrincipal = classe.idEnseignantPrincipal();
        nomClasse = classe.nomClasse();
        effectifMax = classe.effectifMax();
        salle = classe.salle();
        commentaire = classe.commentaire();

        ClasseDTO classeDTO = new ClasseDTO( idClasse, idAnnee, idNiveau, idEnseignantPrincipal, nomClasse, effectifMax, salle, commentaire );

        return classeDTO;
    }

    @Override
    public Classe toDomain(ClasseDTO classeDTO) {
        if ( classeDTO == null ) {
            return null;
        }

        Long idClasse = null;
        Long idAnnee = null;
        Long idNiveau = null;
        Long idEnseignantPrincipal = null;
        String nomClasse = null;
        Integer effectifMax = null;
        String salle = null;
        String commentaire = null;

        idClasse = classeDTO.idClasse();
        idAnnee = classeDTO.idAnnee();
        idNiveau = classeDTO.idNiveau();
        idEnseignantPrincipal = classeDTO.idEnseignantPrincipal();
        nomClasse = classeDTO.nomClasse();
        effectifMax = classeDTO.effectifMax();
        salle = classeDTO.salle();
        commentaire = classeDTO.commentaire();

        Classe classe = new Classe( idClasse, idAnnee, idNiveau, idEnseignantPrincipal, nomClasse, effectifMax, salle, commentaire );

        return classe;
    }
}
