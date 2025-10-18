package dz.tarbiya.madrassa.adapter.out.jpa.matiere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereJpaRepository extends JpaRepository<MatiereEntity, Long> {
}