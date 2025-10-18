package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Bulletin;
import java.util.List;

public interface BulletinRepository {
    Bulletin save(Bulletin bulletin);
    List<Bulletin> findAll();
    Bulletin findById(Long id);
    void deleteById(Long id);
}
