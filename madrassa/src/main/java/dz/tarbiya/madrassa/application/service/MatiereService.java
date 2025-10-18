package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Matiere;
import dz.tarbiya.madrassa.application.port.MatiereRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatiereService {
    private final MatiereRepository repository;
    public MatiereService(MatiereRepository repository) { this.repository = repository; }
    public Matiere save(Matiere matiere) { return repository.save(matiere); }
    public List<Matiere> findAll() { return repository.findAll(); }
    public Matiere findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
