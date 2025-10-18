package dz.tarbiya.madrassa.adapter.out.jpa.cours;

import dz.tarbiya.madrassa.application.port.CoursRepository;
import dz.tarbiya.madrassa.domain.model.Cours;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CoursRepositoryAdapter implements CoursRepository {
    
    private final CoursJpaRepository jpaRepository;
    
    public CoursRepositoryAdapter(CoursJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Cours save(Cours cours) {
        CoursEntity entity = toEntity(cours);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<Cours> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Cours findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private Cours toDomain(CoursEntity entity) {
        return new Cours(
            entity.getIdCours(),
            entity.getIdClasse(),
            entity.getIdMatiere(),
            entity.getIdEnseignant(),
            entity.getIdAnnee(),
            entity.getHeuresSemaine(),
            entity.getCoefficient(),
            entity.getSalle()
        );
    }
    
    private CoursEntity toEntity(Cours cours) {
        CoursEntity entity = new CoursEntity();
        entity.setIdCours(cours.idCours());
        entity.setIdClasse(cours.idClasse());
        entity.setIdMatiere(cours.idMatiere());
        entity.setIdEnseignant(cours.idEnseignant());
        entity.setIdAnnee(cours.idAnnee());
        entity.setHeuresSemaine(cours.heuresSemaine());
        entity.setCoefficient(cours.coefficient());
        entity.setSalle(cours.salle());
        return entity;
    }
}