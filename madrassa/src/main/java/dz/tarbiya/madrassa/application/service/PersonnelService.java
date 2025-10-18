package dz.tarbiya.madrassa.application.service;
import dz.tarbiya.madrassa.domain.model.Personnel;
import dz.tarbiya.madrassa.application.port.PersonnelRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonnelService {
    private final PersonnelRepository repository;
    public PersonnelService(PersonnelRepository repository) { this.repository = repository; }
    public Personnel save(Personnel personnel) { return repository.save(personnel); }
    public List<Personnel> findAll() { return repository.findAll(); }
    public Personnel findById(Long id) { return repository.findById(id); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
