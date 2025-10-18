package dz.tarbiya.madrassa.adapter.out.jpa.evaluation;

import dz.tarbiya.madrassa.application.port.EvaluationRepository;
import dz.tarbiya.madrassa.domain.model.Evaluation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EvaluationRepositoryAdapter implements EvaluationRepository {
    private final EvaluationJpaRepository jpaRepository;

    public EvaluationRepositoryAdapter(EvaluationJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Evaluation findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }

    @Override
    public Evaluation save(Evaluation evaluation) {
        EvaluationEntity entity = toEntity(evaluation);
        EvaluationEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Evaluation> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private Evaluation toDomain(EvaluationEntity entity) {
        // Only map fields present in entity, others set to null
        return new Evaluation(
                entity.getIdEvaluation(),
                null, // idCours
                null, // idPeriode
                null, // idTypeEval
                null, // intitule
                null, // dateEvaluation
                null, // noteSur
                entity.getCoefficient(),
                null, // dureeMinutes
                null, // commentaire
                entity.getDateEvaluation() // mapped to dateCreation
        );
    }

    private EvaluationEntity toEntity(Evaluation evaluation) {
        EvaluationEntity entity = new EvaluationEntity();
        entity.setIdEvaluation(evaluation.idEvaluation());
        entity.setCoefficient(evaluation.coefficient());
        entity.setDateEvaluation(evaluation.dateCreation());
        // Other fields not present in entity
        return entity;
    }
}
