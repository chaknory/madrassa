package dz.tarbiya.madrassa.adapter.out.jpa.responsablelegal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableLegalJpaRepository extends JpaRepository<ResponsableLegalEntity, Long> {
}