package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Retard;
import dz.tarbiya.madrassa.application.port.RetardRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RetardService {
    private final RetardRepository repository;
    public RetardService(RetardRepository repository) { this.repository = repository; }
    public Retard save(Retard retard) { return repository.save(retard); }
    public List<Retard> findAll() { return repository.findAll(); }
    public Retard findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
