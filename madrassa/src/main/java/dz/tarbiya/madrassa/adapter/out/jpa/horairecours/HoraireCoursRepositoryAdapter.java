package dz.tarbiya.madrassa.adapter.out.jpa.horairecours;

import dz.tarbiya.madrassa.application.port.HoraireCoursRepository;
import dz.tarbiya.madrassa.domain.model.HoraireCours;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HoraireCoursRepositoryAdapter implements HoraireCoursRepository {
    
    private final HoraireCoursJpaRepository jpaRepository;
    
    public HoraireCoursRepositoryAdapter(HoraireCoursJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public HoraireCours save(HoraireCours horaireCours) {
        HoraireCoursEntity entity = toEntity(horaireCours);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<HoraireCours> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public HoraireCours findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private HoraireCours toDomain(HoraireCoursEntity entity) {
        return new HoraireCours(
            entity.getIdHoraire(),
            entity.getIdCours(),
            entity.getJourSemaine(),
            entity.getHeureDebut(),
            entity.getHeureFin(),
            entity.getSalle()
        );
    }
    
    private HoraireCoursEntity toEntity(HoraireCours horaireCours) {
        HoraireCoursEntity entity = new HoraireCoursEntity();
        entity.setIdHoraire(horaireCours.idHoraire());
        entity.setIdCours(horaireCours.idCours());
        entity.setJourSemaine(horaireCours.jourSemaine());
        entity.setHeureDebut(horaireCours.heureDebut());
        entity.setHeureFin(horaireCours.heureFin());
        entity.setSalle(horaireCours.salle());
        return entity;
    }
}