package dz.tarbiya.madrassa.adapter.out.jpa.periode;

import dz.tarbiya.madrassa.application.port.PeriodeRepository;
import dz.tarbiya.madrassa.domain.model.Periode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PeriodeRepositoryAdapter implements PeriodeRepository {
    
    private final PeriodeJpaRepository jpaRepository;
    
    public PeriodeRepositoryAdapter(PeriodeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    
    @Override
    public Periode save(Periode periode) {
        PeriodeEntity entity = toEntity(periode);
        return toDomain(jpaRepository.save(entity));
    }
    
    @Override
    public List<Periode> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    @Override
    public Periode findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }
    
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
    
    private Periode toDomain(PeriodeEntity entity) {
        return new Periode(
            entity.getIdPeriode(),
            entity.getIdAnnee(),
            entity.getLibelle(),
            entity.getNumeroPeriode(),
            entity.getDateDebut(),
            entity.getDateFin(),
            entity.getCloturee()
        );
    }
    
    private PeriodeEntity toEntity(Periode periode) {
        PeriodeEntity entity = new PeriodeEntity();
        entity.setIdPeriode(periode.idPeriode());
        entity.setIdAnnee(periode.idAnnee());
        entity.setLibelle(periode.libelle());
        entity.setNumeroPeriode(periode.numeroPeriode());
        entity.setDateDebut(periode.dateDebut());
        entity.setDateFin(periode.dateFin());
        entity.setCloturee(periode.cloturee());
        return entity;
    }
}