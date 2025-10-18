package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Cours;
import dz.tarbiya.madrassa.application.port.CoursRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CoursService {
    private final CoursRepository repository;
    public CoursService(CoursRepository repository) { this.repository = repository; }
    public Cours save(Cours cours) { return repository.save(cours); }
    public List<Cours> findAll() { return repository.findAll(); }
    public Cours findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
