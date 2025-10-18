package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.HoraireCours;
import dz.tarbiya.madrassa.application.port.HoraireCoursRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HoraireCoursService {
    private final HoraireCoursRepository repository;
    public HoraireCoursService(HoraireCoursRepository repository) { this.repository = repository; }
    public HoraireCours save(HoraireCours horaireCours) { return repository.save(horaireCours); }
    public List<HoraireCours> findAll() { return repository.findAll(); }
    public HoraireCours findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
