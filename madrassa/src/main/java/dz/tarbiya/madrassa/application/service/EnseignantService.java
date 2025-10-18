package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Enseignant;
import dz.tarbiya.madrassa.application.port.EnseignantRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnseignantService {
    private final EnseignantRepository repository;
    public EnseignantService(EnseignantRepository repository) { this.repository = repository; }
    public Enseignant save(Enseignant enseignant) { return repository.save(enseignant); }
    public List<Enseignant> findAll() { return repository.findAll(); }
    public Enseignant findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
