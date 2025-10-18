package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Niveau;
import dz.tarbiya.madrassa.application.port.NiveauRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NiveauService {
    private final NiveauRepository repository;
    public NiveauService(NiveauRepository repository) { this.repository = repository; }
    public Niveau save(Niveau niveau) { return repository.save(niveau); }
    public List<Niveau> findAll() { return repository.findAll(); }
    public Niveau findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
