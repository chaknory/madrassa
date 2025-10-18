package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Personne;
import dz.tarbiya.madrassa.application.port.PersonneRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonneService {
    private final PersonneRepository repository;
    public PersonneService(PersonneRepository repository) { this.repository = repository; }
    public Personne save(Personne personne) { return repository.save(personne); }
    public List<Personne> findAll() { return repository.findAll(); }
    public Personne findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
