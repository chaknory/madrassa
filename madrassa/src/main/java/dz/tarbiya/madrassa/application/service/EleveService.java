package dz.tarbiya.madrassa.application.service;

import dz.tarbiya.madrassa.domain.model.Eleve;
import dz.tarbiya.madrassa.application.port.EleveRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EleveService {
    private final EleveRepository repository;

    public EleveService(EleveRepository repository) {
        this.repository = repository;
    }

    public Eleve save(Eleve eleve) {
        return repository.save(eleve);
    }

    public List<Eleve> findAll() {
        System.out.println("🔄 Service: Début de findAll() - " + new java.util.Date());
        List<Eleve> eleves = repository.findAll();
        System.out.println("✅ Service: Fin de findAll() - " + eleves.size() + " élèves trouvés - " + new java.util.Date());
        return eleves;
    }

    public Eleve findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
