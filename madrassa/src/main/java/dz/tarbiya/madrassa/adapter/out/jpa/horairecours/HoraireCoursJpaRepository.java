package dz.tarbiya.madrassa.adapter.out.jpa.horairecours;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoraireCoursJpaRepository extends JpaRepository<HoraireCoursEntity, Long> {
}