package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.BulletinDetail;
import java.util.List;

public interface BulletinDetailRepository {
    BulletinDetail save(BulletinDetail bulletinDetail);
    List<BulletinDetail> findAll();
    BulletinDetail findById(Long id);
    void deleteById(Long id);
}
