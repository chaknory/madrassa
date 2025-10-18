package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.AnneeScolaire;
import java.util.List;

public interface AnneeScolaireRepository {
    AnneeScolaire save(AnneeScolaire anneeScolaire);
    List<AnneeScolaire> findAll();
    AnneeScolaire findById(Long id);
    void deleteById(Long id);
    AnneeScolaire findByActiveTrue();
}
