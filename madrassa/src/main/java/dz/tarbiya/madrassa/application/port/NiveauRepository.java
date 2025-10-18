package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Niveau;
import java.util.List;

public interface NiveauRepository {
    Niveau save(Niveau niveau);
    List<Niveau> findAll();
    Niveau findById(Long id);
    void deleteById(Long id);
}
