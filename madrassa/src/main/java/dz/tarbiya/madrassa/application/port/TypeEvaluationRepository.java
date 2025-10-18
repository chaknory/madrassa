package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.TypeEvaluation;
import java.util.List;

public interface TypeEvaluationRepository {
    TypeEvaluation save(TypeEvaluation typeEvaluation);
    List<TypeEvaluation> findAll();
    TypeEvaluation findById(Long id);
    void deleteById(Long id);
}
