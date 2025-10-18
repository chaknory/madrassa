package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Periode;
import java.util.List;

public interface PeriodeRepository {
    Periode save(Periode periode);
    List<Periode> findAll();
    Periode findById(Long id);
    void deleteById(Long id);
}
