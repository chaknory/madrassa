package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Matiere;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:30+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class MatiereDtoMapperImpl implements MatiereDtoMapper {

    @Override
    public MatiereDTO toDto(Matiere matiere) {
        if ( matiere == null ) {
            return null;
        }

        Long idMatiere = null;
        String code = null;
        String libelle = null;
        String description = null;
        Double coefficient = null;
        String couleur = null;
        Boolean actif = null;

        idMatiere = matiere.idMatiere();
        code = matiere.code();
        libelle = matiere.libelle();
        description = matiere.description();
        coefficient = matiere.coefficient();
        couleur = matiere.couleur();
        actif = matiere.actif();

        MatiereDTO matiereDTO = new MatiereDTO( idMatiere, code, libelle, description, coefficient, couleur, actif );

        return matiereDTO;
    }

    @Override
    public Matiere toDomain(MatiereDTO matiereDTO) {
        if ( matiereDTO == null ) {
            return null;
        }

        Long idMatiere = null;
        String code = null;
        String libelle = null;
        String description = null;
        Double coefficient = null;
        String couleur = null;
        Boolean actif = null;

        idMatiere = matiereDTO.idMatiere();
        code = matiereDTO.code();
        libelle = matiereDTO.libelle();
        description = matiereDTO.description();
        coefficient = matiereDTO.coefficient();
        couleur = matiereDTO.couleur();
        actif = matiereDTO.actif();

        Matiere matiere = new Matiere( idMatiere, code, libelle, description, coefficient, couleur, actif );

        return matiere;
    }
}
