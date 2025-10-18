package dz.tarbiya.madrassa.adapter.out.jpa.responsablelegal;

import dz.tarbiya.madrassa.application.port.ResponsableLegalRepository;
import dz.tarbiya.madrassa.domain.model.ResponsableLegal;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResponsableLegalRepositoryAdapter implements ResponsableLegalRepository {
    
    private final ResponsableLegalJpaRepository jpaRepository;
    
    public ResponsableLegalRepositoryAdapter(ResponsableLegalJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public ResponsableLegal save(ResponsableLegal responsableLegal) {
        ResponsableLegalEntity entity = toEntity(responsableLegal);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<ResponsableLegal> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public ResponsableLegal findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private ResponsableLegal toDomain(ResponsableLegalEntity entity) {
        return new ResponsableLegal(
            entity.getIdResponsable(),
            entity.getNom(),
            entity.getPrenom(),
            entity.getTelephone(),
            entity.getTelephoneMobile(),
            entity.getEmail(),
            entity.getAdresse(),
            entity.getProfession(),
            entity.getLienParente(),
            entity.getContactUrgence(),
            entity.getAutoriseSortie(),
            entity.getDateCreation()
        );
    }
    
    private ResponsableLegalEntity toEntity(ResponsableLegal responsableLegal) {
        ResponsableLegalEntity entity = new ResponsableLegalEntity();
        entity.setIdResponsable(responsableLegal.idResponsable());
        entity.setNom(responsableLegal.nom());
        entity.setPrenom(responsableLegal.prenom());
        entity.setTelephone(responsableLegal.telephone());
        entity.setTelephoneMobile(responsableLegal.telephoneMobile());
        entity.setEmail(responsableLegal.email());
        entity.setAdresse(responsableLegal.adresse());
        entity.setProfession(responsableLegal.profession());
        entity.setLienParente(responsableLegal.lienParente());
        entity.setContactUrgence(responsableLegal.contactUrgence());
        entity.setAutoriseSortie(responsableLegal.autoriseSortie());
        entity.setDateCreation(responsableLegal.dateCreation());
        return entity;
    }
}