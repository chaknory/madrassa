package dz.tarbiya.madrassa.adapter.out.jpa.niveau;

import dz.tarbiya.madrassa.application.port.NiveauRepository;
import dz.tarbiya.madrassa.domain.model.Niveau;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NiveauRepositoryAdapter implements NiveauRepository {
    
    private final NiveauJpaRepository jpaRepository;
    
    public NiveauRepositoryAdapter(NiveauJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Niveau save(Niveau niveau) {
        NiveauEntity entity = toEntity(niveau);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<Niveau> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Niveau findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private Niveau toDomain(NiveauEntity entity) {
        return new Niveau(
            entity.getIdNiveau(),
            entity.getCode(),
            entity.getLibelle(),
            entity.getOrdre(),
            entity.getCycle()
        );
    }
    
    private NiveauEntity toEntity(Niveau niveau) {
        NiveauEntity entity = new NiveauEntity();
        entity.setIdNiveau(niveau.idNiveau());
        entity.setCode(niveau.code());
        entity.setLibelle(niveau.libelle());
        entity.setOrdre(niveau.ordre());
        entity.setCycle(niveau.cycle());
        return entity;
    }
}