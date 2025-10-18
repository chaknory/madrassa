package dz.tarbiya.madrassa.adapter.out.jpa.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationJpaRepository extends JpaRepository<EvaluationEntity, Long> {
}
