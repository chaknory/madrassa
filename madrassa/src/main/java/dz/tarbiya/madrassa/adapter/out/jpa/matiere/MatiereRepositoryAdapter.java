package dz.tarbiya.madrassa.adapter.out.jpa.matiere;

import dz.tarbiya.madrassa.application.port.MatiereRepository;
import dz.tarbiya.madrassa.domain.model.Matiere;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MatiereRepositoryAdapter implements MatiereRepository {
    
    private final MatiereJpaRepository jpaRepository;
    
    public MatiereRepositoryAdapter(MatiereJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Matiere save(Matiere matiere) {
        MatiereEntity entity = toEntity(matiere);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<Matiere> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Matiere findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private Matiere toDomain(MatiereEntity entity) {
        return new Matiere(
            entity.getIdMatiere(),
            entity.getCode(),
            entity.getLibelle(),
            entity.getDescription(),
            entity.getCoefficient(),
            entity.getCouleur(),
            entity.getActif()
        );
    }
    
    private MatiereEntity toEntity(Matiere matiere) {
        MatiereEntity entity = new MatiereEntity();
        entity.setIdMatiere(matiere.idMatiere());
        entity.setCode(matiere.code());
        entity.setLibelle(matiere.libelle());
        entity.setDescription(matiere.description());
        entity.setCoefficient(matiere.coefficient());
        entity.setCouleur(matiere.couleur());
        entity.setActif(matiere.actif());
        return entity;
    }
}