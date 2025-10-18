package dz.tarbiya.madrassa.adapter.out.jpa.niveau;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauJpaRepository extends JpaRepository<NiveauEntity, Long> {
}