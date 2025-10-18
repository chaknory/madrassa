package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Evaluation;
import dz.tarbiya.madrassa.application.port.EvaluationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EvaluationService {
    private final EvaluationRepository repository;
    public EvaluationService(EvaluationRepository repository) { this.repository = repository; }
    public Evaluation save(Evaluation evaluation) { return repository.save(evaluation); }
    public List<Evaluation> findAll() { return repository.findAll(); }
    public Evaluation findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
