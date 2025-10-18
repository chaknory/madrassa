package dz.tarbiya.madrassa.adapter.out.jpa;

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
public class PersonneMapperImpl implements PersonneMapper {

    @Override
    public PersonneEntity toEntity(Personne personne) {
        if ( personne == null ) {
            return null;
        }

        PersonneEntity personneEntity = new PersonneEntity();

        personneEntity.setIdPersonne( personne.idPersonne() );
        personneEntity.setNom( personne.nom() );
        personneEntity.setPrenom( personne.prenom() );
        personneEntity.setDateNaissance( personne.dateNaissance() );
        personneEntity.setSexe( personne.sexe() );
        personneEntity.setEmail( personne.email() );
        personneEntity.setTelephone( personne.telephone() );
        personneEntity.setTelephoneMobile( personne.telephoneMobile() );
        personneEntity.setAdresse( personne.adresse() );
        personneEntity.setCodePostal( personne.codePostal() );
        personneEntity.setVille( personne.ville() );
        personneEntity.setPays( personne.pays() );
        personneEntity.setPhotoUrl( personne.photoUrl() );
        personneEntity.setTypePersonne( personne.typePersonne() );
        personneEntity.setActif( personne.actif() );
        personneEntity.setDateCreation( personne.dateCreation() );
        personneEntity.setDateModification( personne.dateModification() );

        return personneEntity;
    }

    @Override
    public Personne toDomain(PersonneEntity entity) {
        if ( entity == null ) {
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

        idPersonne = entity.getIdPersonne();
        nom = entity.getNom();
        prenom = entity.getPrenom();
        dateNaissance = entity.getDateNaissance();
        sexe = entity.getSexe();
        email = entity.getEmail();
        telephone = entity.getTelephone();
        telephoneMobile = entity.getTelephoneMobile();
        adresse = entity.getAdresse();
        codePostal = entity.getCodePostal();
        ville = entity.getVille();
        pays = entity.getPays();
        photoUrl = entity.getPhotoUrl();
        typePersonne = entity.getTypePersonne();
        actif = entity.getActif();
        dateCreation = entity.getDateCreation();
        dateModification = entity.getDateModification();

        Personne personne = new Personne( idPersonne, nom, prenom, dateNaissance, sexe, email, telephone, telephoneMobile, adresse, codePostal, ville, pays, photoUrl, typePersonne, actif, dateCreation, dateModification );

        return personne;
    }
}
