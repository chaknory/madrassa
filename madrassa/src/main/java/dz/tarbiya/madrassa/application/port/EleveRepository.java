package dz.tarbiya.madrassa.application.port;

import dz.tarbiya.madrassa.domain.model.Eleve;
import java.util.List;

public interface EleveRepository {
    Eleve save(Eleve eleve);
    List<Eleve> findAll();
    Eleve findById(Long id);
    void deleteById(Long id);
}
