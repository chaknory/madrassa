package dz.tarbiya.madrassa.adapter.out.jpa.inscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionJpaRepository extends JpaRepository<InscriptionEntity, Long> {
}