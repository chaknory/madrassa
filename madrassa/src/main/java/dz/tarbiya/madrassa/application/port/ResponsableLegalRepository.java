package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.ResponsableLegal;
import java.util.List;

public interface ResponsableLegalRepository {
    ResponsableLegal save(ResponsableLegal responsableLegal);
    List<ResponsableLegal> findAll();
    ResponsableLegal findById(Long id);
    void deleteById(Long id);
}
