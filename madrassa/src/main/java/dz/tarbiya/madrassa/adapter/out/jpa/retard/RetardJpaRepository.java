package dz.tarbiya.madrassa.adapter.out.jpa.retard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetardJpaRepository extends JpaRepository<RetardEntity, Long> {
}