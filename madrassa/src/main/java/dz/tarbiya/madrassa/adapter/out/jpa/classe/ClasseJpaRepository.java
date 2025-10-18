package dz.tarbiya.madrassa.adapter.out.jpa.classe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseJpaRepository extends JpaRepository<ClasseEntity, Long> {
}