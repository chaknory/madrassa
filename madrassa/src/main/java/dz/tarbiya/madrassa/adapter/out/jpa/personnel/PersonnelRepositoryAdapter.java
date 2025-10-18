package dz.tarbiya.madrassa.adapter.out.jpa.personnel;

import dz.tarbiya.madrassa.application.port.PersonnelRepository;
import dz.tarbiya.madrassa.domain.model.Personnel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonnelRepositoryAdapter implements PersonnelRepository {
    
    private final PersonnelJpaRepository jpaRepository;
    
    public PersonnelRepositoryAdapter(PersonnelJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Personnel save(Personnel personnel) {
        PersonnelEntity entity = toEntity(personnel);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<Personnel> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Personnel findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private Personnel toDomain(PersonnelEntity entity) {
        return new Personnel(
            entity.getIdPersonnel(),
            entity.getIdPersonne(),
            entity.getNumeroEmploye(),
            entity.getFonction(),
            entity.getDateEmbauche(),
            entity.getService(),
            entity.getActif()
        );
    }
    
    private PersonnelEntity toEntity(Personnel personnel) {
        PersonnelEntity entity = new PersonnelEntity();
        entity.setIdPersonnel(personnel.idPersonnel());
        entity.setIdPersonne(personnel.idPersonne());
        entity.setNumeroEmploye(personnel.numeroEmploye());
        entity.setFonction(personnel.fonction());
        entity.setDateEmbauche(personnel.dateEmbauche());
        entity.setService(personnel.service());
        entity.setActif(personnel.actif());
        return entity;
    }
}