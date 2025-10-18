package dz.tarbiya.madrassa.adapter.out.jpa.eleve;

import dz.tarbiya.madrassa.application.port.EleveRepository;
import dz.tarbiya.madrassa.domain.model.Eleve;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EleveRepositoryAdapter implements EleveRepository {
    private final EleveJpaRepository jpaRepository;

    public EleveRepositoryAdapter(EleveJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Eleve save(Eleve eleve) {
        EleveEntity entity = new EleveEntity();
        // ... map fields
        return toDomain(jpaRepository.save(entity));
    }

    @Override
    public List<Eleve> findAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Eleve findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private Eleve toDomain(EleveEntity entity) {
        return new Eleve(
            entity.getId(),
            entity.getNom(),
            entity.getPrenom(),
            entity.getDateNaissance(),
            entity.getNumeroEleve()
        );
    }
}
