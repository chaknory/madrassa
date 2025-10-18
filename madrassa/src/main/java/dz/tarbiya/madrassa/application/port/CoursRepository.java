package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Cours;
import java.util.List;

public interface CoursRepository {
    Cours save(Cours cours);
    List<Cours> findAll();
    Cours findById(Long id);
    void deleteById(Long id);
}
