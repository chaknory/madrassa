package dz.tarbiya.madrassa.adapter.out.jpa;

import dz.tarbiya.madrassa.application.port.PersonneRepository;
import dz.tarbiya.madrassa.domain.model.Personne;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonneRepositoryAdapter implements PersonneRepository {
    
    private final PersonneJpaRepository jpaRepository;
    
    public PersonneRepositoryAdapter(PersonneJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Personne save(Personne personne) {
        PersonneEntity entity = toEntity(personne);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<Personne> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Personne findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private Personne toDomain(PersonneEntity entity) {
        return new Personne(
            entity.getIdPersonne(),
            entity.getNom(),
            entity.getPrenom(),
            entity.getDateNaissance(),
            entity.getSexe(),
            entity.getEmail(),
            entity.getTelephone(),
            entity.getTelephoneMobile(),
            entity.getAdresse(),
            entity.getCodePostal(),
            entity.getVille(),
            entity.getPays(),
            entity.getPhotoUrl(),
            entity.getTypePersonne(),
            entity.getActif(),
            entity.getDateCreation(),
            entity.getDateModification()
        );
    }
    
    private PersonneEntity toEntity(Personne personne) {
        PersonneEntity entity = new PersonneEntity();
        entity.setIdPersonne(personne.idPersonne());
        entity.setNom(personne.nom());
        entity.setPrenom(personne.prenom());
        entity.setDateNaissance(personne.dateNaissance());
        entity.setSexe(personne.sexe());
        entity.setEmail(personne.email());
        entity.setTelephone(personne.telephone());
        entity.setTelephoneMobile(personne.telephoneMobile());
        entity.setAdresse(personne.adresse());
        entity.setCodePostal(personne.codePostal());
        entity.setVille(personne.ville());
        entity.setPays(personne.pays());
        entity.setPhotoUrl(personne.photoUrl());
        entity.setTypePersonne(personne.typePersonne());
        entity.setActif(personne.actif());
        entity.setDateCreation(personne.dateCreation());
        entity.setDateModification(personne.dateModification());
        return entity;
    }
}