package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Absence;
import java.util.List;

public interface AbsenceRepository {
    Absence save(Absence absence);
    List<Absence> findAll();
    Absence findById(Long id);
    void deleteById(Long id);
}
