package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Classe;
import java.util.List;

public interface ClasseRepository {
    Classe save(Classe classe);
    List<Classe> findAll();
    Classe findById(Long id);
    void deleteById(Long id);
}
