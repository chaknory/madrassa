package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.BulletinDetail;
import dz.tarbiya.madrassa.application.port.BulletinDetailRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BulletinDetailService {
    private final BulletinDetailRepository repository;
    public BulletinDetailService(BulletinDetailRepository repository) { this.repository = repository; }
    public BulletinDetail save(BulletinDetail bulletinDetail) { return repository.save(bulletinDetail); }
    public List<BulletinDetail> findAll() { return repository.findAll(); }
    public BulletinDetail findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
