package dz.tarbiya.madrassa.adapter.out.jpa.anneescolaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneeScolaireJpaRepository extends JpaRepository<AnneeScolaireEntity, Long> {
    AnneeScolaireEntity findByActiveTrue();
}