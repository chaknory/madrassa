package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Personnel;
import java.util.List;

public interface PersonnelRepository {
    Personnel save(Personnel personnel);
    List<Personnel> findAll();
    Personnel findById(Long id);
    void deleteById(Long id);
}
