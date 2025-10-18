package dz.tarbiya.madrassa.adapter.out.jpa.periode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodeJpaRepository extends JpaRepository<PeriodeEntity, Long> {
}