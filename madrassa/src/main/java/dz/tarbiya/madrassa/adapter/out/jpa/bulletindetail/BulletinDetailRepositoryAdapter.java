package dz.tarbiya.madrassa.adapter.out.jpa.bulletindetail;

import dz.tarbiya.madrassa.application.port.BulletinDetailRepository;
import dz.tarbiya.madrassa.domain.model.BulletinDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BulletinDetailRepositoryAdapter implements BulletinDetailRepository {

    private final BulletinDetailJpaRepository jpaRepository;

    public BulletinDetailRepositoryAdapter(BulletinDetailJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public BulletinDetail findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toDomain)
                .orElse(null);
    }

    @Override
    public BulletinDetail save(BulletinDetail bulletinDetail) {
        BulletinDetailEntity entity = toEntity(bulletinDetail);
        BulletinDetailEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<BulletinDetail> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    public List<BulletinDetail> findByIdBulletin(Long idBulletin) {
        return jpaRepository.findByIdBulletin(idBulletin).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<BulletinDetail> findByIdMatiere(Long idMatiere) {
        return jpaRepository.findByIdMatiere(idMatiere).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public Optional<BulletinDetail> findByIdBulletinAndIdMatiere(Long idBulletin, Long idMatiere) {
        List<BulletinDetailEntity> entities = jpaRepository.findByIdBulletinAndIdMatiere(idBulletin, idMatiere);
        return entities.isEmpty() ? Optional.empty() : Optional.of(toDomain(entities.get(0)));
    }

    public List<BulletinDetail> findByIdBulletinOrderByRang(Long idBulletin) {
        return jpaRepository.findByIdBulletinOrderByRang(idBulletin).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<BulletinDetail> findByMoyenneGreaterThanEqual(Double moyenneMin) {
        return jpaRepository.findByMoyenneGreaterThanEqual(moyenneMin).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<BulletinDetail> findByIdBulletinAndMoyenneGreaterThanEqual(Long idBulletin, Double moyenneMin) {
        return jpaRepository.findByIdBulletinAndMoyenneGreaterThanEqual(idBulletin, moyenneMin).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public Double findAverageMoyenneByIdBulletin(Long idBulletin) {
        return jpaRepository.findAverageMoyenneByIdBulletin(idBulletin);
    }

    private BulletinDetail toDomain(BulletinDetailEntity entity) {
    // moyenneClasse, noteMin, noteMax are not present in the entity, set to null
    return new BulletinDetail(
        entity.getIdBulletinDetail(),
        entity.getIdBulletin(),
        entity.getIdMatiere(),
        entity.getMoyenne(),
        entity.getCoefficient(),
        entity.getRang(),
        null, // moyenneClasse
        null, // noteMin
        null, // noteMax
        entity.getAppreciation()
    );
    }

    private BulletinDetailEntity toEntity(BulletinDetail bulletinDetail) {
        BulletinDetailEntity entity = new BulletinDetailEntity();
        entity.setIdBulletinDetail(bulletinDetail.idBulletinDetail());
        entity.setIdBulletin(bulletinDetail.idBulletin());
        entity.setIdMatiere(bulletinDetail.idMatiere());
        entity.setMoyenne(bulletinDetail.moyenne());
        entity.setCoefficient(bulletinDetail.coefficient());
        entity.setRang(bulletinDetail.rang());
        entity.setAppreciation(bulletinDetail.appreciation());
        // moyenneClasse, noteMin, noteMax, and other fields are not present in entity
        return entity;
    }
}