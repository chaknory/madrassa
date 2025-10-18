package dz.tarbiya.madrassa.adapter.out.jpa.enseignant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantJpaRepository extends JpaRepository<EnseignantEntity, Long> {
}