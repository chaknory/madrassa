package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Retard;
import java.util.List;

public interface RetardRepository {
    Retard save(Retard retard);
    List<Retard> findAll();
    Retard findById(Long id);
    void deleteById(Long id);
}
