package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Enseignant;
import java.util.List;

public interface EnseignantRepository {
    Enseignant save(Enseignant enseignant);
    List<Enseignant> findAll();
    Enseignant findById(Long id);
    void deleteById(Long id);
}
