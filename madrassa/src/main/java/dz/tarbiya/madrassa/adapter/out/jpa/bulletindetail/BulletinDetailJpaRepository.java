package dz.tarbiya.madrassa.adapter.out.jpa.bulletindetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BulletinDetailJpaRepository extends JpaRepository<BulletinDetailEntity, Long> {
    
    List<BulletinDetailEntity> findByIdBulletin(Long idBulletin);
    
    List<BulletinDetailEntity> findByIdMatiere(Long idMatiere);
    
    List<BulletinDetailEntity> findByIdBulletinAndIdMatiere(Long idBulletin, Long idMatiere);
    
    @Query("SELECT bd FROM BulletinDetailEntity bd WHERE bd.idBulletin = :idBulletin ORDER BY bd.rang ASC")
    List<BulletinDetailEntity> findByIdBulletinOrderByRang(@Param("idBulletin") Long idBulletin);
    
    @Query("SELECT bd FROM BulletinDetailEntity bd WHERE bd.moyenne >= :moyenneMin")
    List<BulletinDetailEntity> findByMoyenneGreaterThanEqual(@Param("moyenneMin") Double moyenneMin);
    
    @Query("SELECT bd FROM BulletinDetailEntity bd WHERE bd.idBulletin = :idBulletin AND bd.moyenne >= :moyenneMin")
    List<BulletinDetailEntity> findByIdBulletinAndMoyenneGreaterThanEqual(@Param("idBulletin") Long idBulletin, @Param("moyenneMin") Double moyenneMin);
    
    @Query("SELECT AVG(bd.moyenne) FROM BulletinDetailEntity bd WHERE bd.idBulletin = :idBulletin")
    Double findAverageMoyenneByIdBulletin(@Param("idBulletin") Long idBulletin);
}