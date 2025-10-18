package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Periode;
import dz.tarbiya.madrassa.application.port.PeriodeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeriodeService {
    private final PeriodeRepository repository;
    public PeriodeService(PeriodeRepository repository) { this.repository = repository; }
    public Periode save(Periode periode) { return repository.save(periode); }
    public List<Periode> findAll() { return repository.findAll(); }
    public Periode findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
