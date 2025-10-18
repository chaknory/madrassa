package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.TypeEvaluation;
import dz.tarbiya.madrassa.application.port.TypeEvaluationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TypeEvaluationService {
    private final TypeEvaluationRepository repository;
    public TypeEvaluationService(TypeEvaluationRepository repository) { this.repository = repository; }
    public TypeEvaluation save(TypeEvaluation typeEvaluation) { return repository.save(typeEvaluation); }
    public List<TypeEvaluation> findAll() { return repository.findAll(); }
    public TypeEvaluation findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
