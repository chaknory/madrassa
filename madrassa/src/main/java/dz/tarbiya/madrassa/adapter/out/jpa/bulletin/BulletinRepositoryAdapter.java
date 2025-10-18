package dz.tarbiya.madrassa.adapter.out.jpa.bulletin;

import dz.tarbiya.madrassa.application.port.BulletinRepository;
import dz.tarbiya.madrassa.domain.model.Bulletin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BulletinRepositoryAdapter implements BulletinRepository {

    private final BulletinJpaRepository jpaRepository;

    public BulletinRepositoryAdapter(BulletinJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Bulletin findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }

    @Override
    public Bulletin save(Bulletin bulletin) {
        BulletinEntity entity = toEntity(bulletin);
        BulletinEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Bulletin> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    public List<Bulletin> findByIdEleve(Long idEleve) {
        return jpaRepository.findByIdEleve(idEleve).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<Bulletin> findByIdClasse(Long idClasse) {
        return jpaRepository.findByIdClasse(idClasse).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<Bulletin> findByIdPeriode(Long idPeriode) {
        return jpaRepository.findByIdPeriode(idPeriode).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<Bulletin> findByIdEleveAndIdPeriode(Long idEleve, Long idPeriode) {
        return jpaRepository.findByIdEleveAndIdPeriode(idEleve, idPeriode).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<Bulletin> findByIdClasseAndIdPeriode(Long idClasse, Long idPeriode) {
        return jpaRepository.findByIdClasseAndIdPeriode(idClasse, idPeriode).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public Optional<Bulletin> findByIdEleveAndIdClasseAndIdPeriode(Long idEleve, Long idClasse, Long idPeriode) {
        BulletinEntity entity = jpaRepository.findByIdEleveAndIdClasseAndIdPeriode(idEleve, idClasse, idPeriode);
        return entity != null ? Optional.of(toDomain(entity)) : Optional.empty();
    }

    public List<Bulletin> findByValide(Boolean valide) {
        return jpaRepository.findByValide(valide).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<Bulletin> findByIdClasseAndIdPeriodeOrderByRang(Long idClasse, Long idPeriode) {
        return jpaRepository.findByIdClasseAndIdPeriodeOrderByRang(idClasse, idPeriode).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<Bulletin> findByMoyenneGeneraleGreaterThanEqual(Double moyenneMin) {
        return jpaRepository.findByMoyenneGeneraleGreaterThanEqual(moyenneMin).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private Bulletin toDomain(BulletinEntity entity) {
        return new Bulletin(
                entity.getIdBulletin(),
                entity.getIdEleve(),
                entity.getIdClasse(),
                entity.getIdPeriode(),
                entity.getMoyenneGenerale(),
                entity.getRang(),
                entity.getTotalEleves(),
                entity.getNbAbsences(),
                entity.getNbRetards(),
                entity.getAppreciationGenerale(),
                entity.getDecisionConseil(),
                entity.getDateConseil(),
                entity.getDateGeneration(),
                entity.getValide(),
                entity.getDateValidation()
        );
    }

    private BulletinEntity toEntity(Bulletin bulletin) {
        BulletinEntity entity = new BulletinEntity();
        entity.setIdBulletin(bulletin.idBulletin());
        entity.setIdEleve(bulletin.idEleve());
        entity.setIdClasse(bulletin.idClasse());
        entity.setIdPeriode(bulletin.idPeriode());
        entity.setMoyenneGenerale(bulletin.moyenneGenerale());
        entity.setRang(bulletin.rang());
        entity.setTotalEleves(bulletin.totalEleves());
        entity.setNbAbsences(bulletin.nbAbsences());
        entity.setNbRetards(bulletin.nbRetards());
        entity.setAppreciationGenerale(bulletin.appreciationGenerale());
        entity.setDecisionConseil(bulletin.decisionConseil());
        entity.setDateConseil(bulletin.dateConseil());
        entity.setDateGeneration(bulletin.dateGeneration());
        entity.setValide(bulletin.valide());
        entity.setDateValidation(bulletin.dateValidation());
        return entity;
    }
}