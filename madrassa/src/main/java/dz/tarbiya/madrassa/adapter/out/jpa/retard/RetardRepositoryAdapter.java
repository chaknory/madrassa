package dz.tarbiya.madrassa.adapter.out.jpa.retard;

import dz.tarbiya.madrassa.application.port.RetardRepository;
import dz.tarbiya.madrassa.domain.model.Retard;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RetardRepositoryAdapter implements RetardRepository {
    
    private final RetardJpaRepository jpaRepository;
    
    public RetardRepositoryAdapter(RetardJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Retard save(Retard retard) {
        RetardEntity entity = toEntity(retard);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<Retard> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Retard findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private Retard toDomain(RetardEntity entity) {
        return new Retard(
            entity.getIdRetard(),
            entity.getIdEleve(),
            entity.getIdCours(),
            entity.getDateRetard(),
            entity.getHeureArrivee(),
            entity.getDureeMinutes(),
            entity.getJustifie(),
            entity.getMotif()
        );
    }
    
    private RetardEntity toEntity(Retard retard) {
        RetardEntity entity = new RetardEntity();
        entity.setIdRetard(retard.idRetard());
        entity.setIdEleve(retard.idEleve());
        entity.setIdCours(retard.idCours());
        entity.setDateRetard(retard.dateRetard());
        entity.setHeureArrivee(retard.heureArrivee());
        entity.setDureeMinutes(retard.dureeMinutes());
        entity.setJustifie(retard.justifie());
        entity.setMotif(retard.motif());
        return entity;
    }
}