package dz.tarbiya.madrassa.adapter.out.jpa.anneescolaire;

import dz.tarbiya.madrassa.application.port.AnneeScolaireRepository;
import dz.tarbiya.madrassa.domain.model.AnneeScolaire;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnneeScolaireRepositoryAdapter implements AnneeScolaireRepository {
    
    private final AnneeScolaireJpaRepository jpaRepository;
    
    public AnneeScolaireRepositoryAdapter(AnneeScolaireJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public AnneeScolaire save(AnneeScolaire anneeScolaire) {
        AnneeScolaireEntity entity = toEntity(anneeScolaire);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<AnneeScolaire> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public AnneeScolaire findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    @Override
    public AnneeScolaire findByActiveTrue() {
        AnneeScolaireEntity entity = jpaRepository.findByActiveTrue();
        return entity != null ? toDomain(entity) : null;
    }
    
    private AnneeScolaire toDomain(AnneeScolaireEntity entity) {
        return new AnneeScolaire(
            entity.getIdAnnee(),
            entity.getLibelle(),
            entity.getDateDebut(),
            entity.getDateFin(),
            entity.getActive()
        );
    }
    
    private AnneeScolaireEntity toEntity(AnneeScolaire anneeScolaire) {
        AnneeScolaireEntity entity = new AnneeScolaireEntity();
        entity.setIdAnnee(anneeScolaire.idAnnee());
        entity.setLibelle(anneeScolaire.libelle());
        entity.setDateDebut(anneeScolaire.dateDebut());
        entity.setDateFin(anneeScolaire.dateFin());
        entity.setActive(anneeScolaire.active());
        return entity;
    }
}