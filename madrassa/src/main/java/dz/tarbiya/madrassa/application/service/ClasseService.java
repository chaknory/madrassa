package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Classe;
import dz.tarbiya.madrassa.application.port.ClasseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClasseService {
    private final ClasseRepository repository;
    public ClasseService(ClasseRepository repository) { this.repository = repository; }
    public Classe save(Classe classe) { return repository.save(classe); }
    public List<Classe> findAll() { return repository.findAll(); }
    public Classe findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
