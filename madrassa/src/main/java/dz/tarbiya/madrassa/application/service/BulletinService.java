package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Bulletin;
import dz.tarbiya.madrassa.application.port.BulletinRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BulletinService {
    private final BulletinRepository repository;
    public BulletinService(BulletinRepository repository) { this.repository = repository; }
    public Bulletin save(Bulletin bulletin) { return repository.save(bulletin); }
    public List<Bulletin> findAll() { return repository.findAll(); }
    public Bulletin findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
