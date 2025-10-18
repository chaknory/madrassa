package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.ResponsableLegal;
import dz.tarbiya.madrassa.application.port.ResponsableLegalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResponsableLegalService {
    private final ResponsableLegalRepository repository;
    public ResponsableLegalService(ResponsableLegalRepository repository) { this.repository = repository; }
    public ResponsableLegal save(ResponsableLegal responsableLegal) { return repository.save(responsableLegal); }
    public List<ResponsableLegal> findAll() { return repository.findAll(); }
    public ResponsableLegal findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
