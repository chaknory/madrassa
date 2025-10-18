package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Matiere;
import java.util.List;

public interface MatiereRepository {
    Matiere save(Matiere matiere);
    List<Matiere> findAll();
    Matiere findById(Long id);
    void deleteById(Long id);
}
