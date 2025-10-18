package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.HoraireCours;
import java.util.List;

public interface HoraireCoursRepository {
    HoraireCours save(HoraireCours horaireCours);
    List<HoraireCours> findAll();
    HoraireCours findById(Long id);
    void deleteById(Long id);
}
