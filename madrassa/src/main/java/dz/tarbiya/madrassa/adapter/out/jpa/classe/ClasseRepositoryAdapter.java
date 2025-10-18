package dz.tarbiya.madrassa.adapter.out.jpa.classe;

import dz.tarbiya.madrassa.application.port.ClasseRepository;
import dz.tarbiya.madrassa.domain.model.Classe;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClasseRepositoryAdapter implements ClasseRepository {
    
    private final ClasseJpaRepository jpaRepository;
    
    public ClasseRepositoryAdapter(ClasseJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Classe save(Classe classe) {
        ClasseEntity entity = toEntity(classe);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<Classe> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Classe findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private Classe toDomain(ClasseEntity entity) {
        return new Classe(
            entity.getIdClasse(),
            entity.getIdAnnee(),
            entity.getIdNiveau(),
            entity.getIdEnseignantPrincipal(),
            entity.getNomClasse(),
            entity.getEffectifMax(),
            entity.getSalle(),
            entity.getCommentaire()
        );
    }
    
    private ClasseEntity toEntity(Classe classe) {
        ClasseEntity entity = new ClasseEntity();
        entity.setIdClasse(classe.idClasse());
        entity.setIdAnnee(classe.idAnnee());
        entity.setIdNiveau(classe.idNiveau());
        entity.setIdEnseignantPrincipal(classe.idEnseignantPrincipal());
        entity.setNomClasse(classe.nomClasse());
        entity.setEffectifMax(classe.effectifMax());
        entity.setSalle(classe.salle());
        entity.setCommentaire(classe.commentaire());
        return entity;
    }
}