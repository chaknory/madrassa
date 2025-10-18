package dz.tarbiya.madrassa.adapter.out.jpa.typeevaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeEvaluationJpaRepository extends JpaRepository<TypeEvaluationEntity, Long> {
}