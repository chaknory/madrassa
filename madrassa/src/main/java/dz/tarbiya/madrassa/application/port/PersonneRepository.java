package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Personne;
import java.util.List;

public interface PersonneRepository {
    Personne save(Personne personne);
    List<Personne> findAll();
    Personne findById(Long id);
    void deleteById(Long id);
}
