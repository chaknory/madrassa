package dz.tarbiya.madrassa.adapter.in.rest.dto;

import dz.tarbiya.madrassa.domain.model.Personne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-13T17:50:30+0200",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PersonneDtoMapperImpl implements PersonneDtoMapper {

    @Override
    public PersonneDTO toDto(Personne personne) {
        if ( personne == null ) {
            return null;
        }

        Long idPersonne = null;
        String nom = null;
        String prenom = null;
        LocalDate dateNaissance = null;
        String sexe = null;
        String email = null;
        String telephone = null;
        String telephoneMobile = null;
        String adresse = null;
        String codePostal = null;
        String ville = null;
        String pays = null;
        String photoUrl = null;
        String typePersonne = null;
        Boolean actif = null;
        LocalDateTime dateCreation = null;
        LocalDateTime dateModification = null;

        idPersonne = personne.idPersonne();
        nom = personne.nom();
        prenom = personne.prenom();
        dateNaissance = personne.dateNaissance();
        sexe = personne.sexe();
        email = personne.email();
        telephone = personne.telephone();
        telephoneMobile = personne.telephoneMobile();
        adresse = personne.adresse();
        codePostal = personne.codePostal();
        ville = personne.ville();
        pays = personne.pays();
        photoUrl = personne.photoUrl();
        typePersonne = personne.typePersonne();
        actif = personne.actif();
        dateCreation = personne.dateCreation();
        dateModification = personne.dateModification();

        PersonneDTO personneDTO = new PersonneDTO( idPersonne, nom, prenom, dateNaissance, sexe, email, telephone, telephoneMobile, adresse, codePostal, ville, pays, photoUrl, typePersonne, actif, dateCreation, dateModification );

        return personneDTO;
    }

    @Override
    public Personne toDomain(PersonneDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Long idPersonne = null;
        String nom = null;
        String prenom = null;
        LocalDate dateNaissance = null;
        String sexe = null;
        String email = null;
        String telephone = null;
        String telephoneMobile = null;
        String adresse = null;
        String codePostal = null;
        String ville = null;
        String pays = null;
        String photoUrl = null;
        String typePersonne = null;
        Boolean actif = null;
        LocalDateTime dateCreation = null;
        LocalDateTime dateModification = null;

        idPersonne = dto.idPersonne();
        nom = dto.nom();
        prenom = dto.prenom();
        dateNaissance = dto.dateNaissance();
        sexe = dto.sexe();
        email = dto.email();
        telephone = dto.telephone();
        telephoneMobile = dto.telephoneMobile();
        adresse = dto.adresse();
        codePostal = dto.codePostal();
        ville = dto.ville();
        pays = dto.pays();
        photoUrl = dto.photoUrl();
        typePersonne = dto.typePersonne();
        actif = dto.actif();
        dateCreation = dto.dateCreation();
        dateModification = dto.dateModification();

        Personne personne = new Personne( idPersonne, nom, prenom, dateNaissance, sexe, email, telephone, telephoneMobile, adresse, codePostal, ville, pays, photoUrl, typePersonne, actif, dateCreation, dateModification );

        return personne;
    }
}
