package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Evaluation;
import java.util.List;

public interface EvaluationRepository {
    Evaluation save(Evaluation evaluation);
    List<Evaluation> findAll();
    Evaluation findById(Long id);
    void deleteById(Long id);
}
