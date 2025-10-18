package dz.tarbiya.madrassa.adapter.out.jpa.bulletin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BulletinJpaRepository extends JpaRepository<BulletinEntity, Long> {
    
    List<BulletinEntity> findByIdEleve(Long idEleve);
    
    List<BulletinEntity> findByIdClasse(Long idClasse);
    
    List<BulletinEntity> findByIdPeriode(Long idPeriode);
    
    List<BulletinEntity> findByIdEleveAndIdPeriode(Long idEleve, Long idPeriode);
    
    List<BulletinEntity> findByIdClasseAndIdPeriode(Long idClasse, Long idPeriode);
    
    BulletinEntity findByIdEleveAndIdClasseAndIdPeriode(Long idEleve, Long idClasse, Long idPeriode);
    
    List<BulletinEntity> findByValide(Boolean valide);
    
    @Query("SELECT b FROM BulletinEntity b WHERE b.idClasse = :idClasse AND b.idPeriode = :idPeriode ORDER BY b.rang ASC")
    List<BulletinEntity> findByIdClasseAndIdPeriodeOrderByRang(@Param("idClasse") Long idClasse, @Param("idPeriode") Long idPeriode);
    
    @Query("SELECT b FROM BulletinEntity b WHERE b.moyenneGenerale >= :moyenneMin")
    List<BulletinEntity> findByMoyenneGeneraleGreaterThanEqual(@Param("moyenneMin") Double moyenneMin);
}