package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Absence;
import dz.tarbiya.madrassa.application.port.AbsenceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AbsenceService {
    private final AbsenceRepository repository;
    public AbsenceService(AbsenceRepository repository) { this.repository = repository; }
    public Absence save(Absence absence) { return repository.save(absence); }
    public List<Absence> findAll() { return repository.findAll(); }
    public Absence findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
