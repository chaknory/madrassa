package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Eleve;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:30+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class EleveDtoMapperImpl implements EleveDtoMapper {

    @Override
    public EleveDTO toDto(Eleve eleve) {
        if ( eleve == null ) {
            return null;
        }

        Long id = null;
        String nom = null;
        String prenom = null;
        LocalDate dateNaissance = null;
        String numeroEleve = null;

        id = eleve.id();
        nom = eleve.nom();
        prenom = eleve.prenom();
        dateNaissance = eleve.dateNaissance();
        numeroEleve = eleve.numeroEleve();

        EleveDTO eleveDTO = new EleveDTO( id, nom, prenom, dateNaissance, numeroEleve );

        return eleveDTO;
    }

    @Override
    public Eleve toDomain(EleveDTO eleveDTO) {
        if ( eleveDTO == null ) {
            return null;
        }

        Long id = null;
        String nom = null;
        String prenom = null;
        LocalDate dateNaissance = null;
        String numeroEleve = null;

        id = eleveDTO.id();
        nom = eleveDTO.nom();
        prenom = eleveDTO.prenom();
        dateNaissance = eleveDTO.dateNaissance();
        numeroEleve = eleveDTO.numeroEleve();

        Eleve eleve = new Eleve( id, nom, prenom, dateNaissance, numeroEleve );

        return eleve;
    }
}
