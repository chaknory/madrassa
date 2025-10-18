package dz.tarbiya.madrassa.adapter.out.jpa.typeevaluation;

import dz.tarbiya.madrassa.application.port.TypeEvaluationRepository;
import dz.tarbiya.madrassa.domain.model.TypeEvaluation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TypeEvaluationRepositoryAdapter implements TypeEvaluationRepository {
    
    private final TypeEvaluationJpaRepository jpaRepository;
    
    public TypeEvaluationRepositoryAdapter(TypeEvaluationJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public TypeEvaluation save(TypeEvaluation typeEvaluation) {
        TypeEvaluationEntity entity = toEntity(typeEvaluation);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<TypeEvaluation> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public TypeEvaluation findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private TypeEvaluation toDomain(TypeEvaluationEntity entity) {
        return new TypeEvaluation(
            entity.getIdTypeEval(),
            entity.getCode(),
            entity.getLibelle(),
            entity.getCoefficient(),
            entity.getCompteMoyenne(),
            entity.getDescription()
        );
    }
    
    private TypeEvaluationEntity toEntity(TypeEvaluation typeEvaluation) {
        TypeEvaluationEntity entity = new TypeEvaluationEntity();
        entity.setIdTypeEval(typeEvaluation.idTypeEval());
        entity.setCode(typeEvaluation.code());
        entity.setLibelle(typeEvaluation.libelle());
        entity.setCoefficient(typeEvaluation.coefficient());
        entity.setCompteMoyenne(typeEvaluation.compteMoyenne());
        entity.setDescription(typeEvaluation.description());
        return entity;
    }
}