package dz.tarbiya.madrassa.application.port;
import dz.tarbiya.madrassa.domain.model.Inscription;
import java.util.List;

public interface InscriptionRepository {
    Inscription save(Inscription inscription);
    List<Inscription> findAll();
    Inscription findById(Long id);
    void deleteById(Long id);
}
