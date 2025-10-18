package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Inscription;
import dz.tarbiya.madrassa.application.port.InscriptionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InscriptionService {
    private final InscriptionRepository repository;
    public InscriptionService(InscriptionRepository repository) { this.repository = repository; }
    public Inscription save(Inscription inscription) { return repository.save(inscription); }
    public List<Inscription> findAll() { return repository.findAll(); }
    public Inscription findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
