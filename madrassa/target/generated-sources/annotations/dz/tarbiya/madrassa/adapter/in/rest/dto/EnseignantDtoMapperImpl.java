package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Enseignant;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:29+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class EnseignantDtoMapperImpl implements EnseignantDtoMapper {

    @Override
    public EnseignantDTO toDto(Enseignant enseignant) {
        if ( enseignant == null ) {
            return null;
        }

        Long idEnseignant = null;
        Long idPersonne = null;
        String numeroEmploye = null;
        LocalDate dateEmbauche = null;
        String specialite = null;
        String diplome = null;
        String statut = null;
        Double volumeHoraireHebdo = null;
        Boolean actif = null;

        idEnseignant = enseignant.idEnseignant();
        idPersonne = enseignant.idPersonne();
        numeroEmploye = enseignant.numeroEmploye();
        dateEmbauche = enseignant.dateEmbauche();
        specialite = enseignant.specialite();
        diplome = enseignant.diplome();
        statut = enseignant.statut();
        volumeHoraireHebdo = enseignant.volumeHoraireHebdo();
        actif = enseignant.actif();

        EnseignantDTO enseignantDTO = new EnseignantDTO( idEnseignant, idPersonne, numeroEmploye, dateEmbauche, specialite, diplome, statut, volumeHoraireHebdo, actif );

        return enseignantDTO;
    }

    @Override
    public Enseignant toDomain(EnseignantDTO enseignantDTO) {
        if ( enseignantDTO == null ) {
            return null;
        }

        Long idEnseignant = null;
        Long idPersonne = null;
        String numeroEmploye = null;
        LocalDate dateEmbauche = null;
        String specialite = null;
        String diplome = null;
        String statut = null;
        Double volumeHoraireHebdo = null;
        Boolean actif = null;

        idEnseignant = enseignantDTO.idEnseignant();
        idPersonne = enseignantDTO.idPersonne();
        numeroEmploye = enseignantDTO.numeroEmploye();
        dateEmbauche = enseignantDTO.dateEmbauche();
        specialite = enseignantDTO.specialite();
        diplome = enseignantDTO.diplome();
        statut = enseignantDTO.statut();
        volumeHoraireHebdo = enseignantDTO.volumeHoraireHebdo();
        actif = enseignantDTO.actif();

        Enseignant enseignant = new Enseignant( idEnseignant, idPersonne, numeroEmploye, dateEmbauche, specialite, diplome, statut, volumeHoraireHebdo, actif );

        return enseignant;
    }
}
