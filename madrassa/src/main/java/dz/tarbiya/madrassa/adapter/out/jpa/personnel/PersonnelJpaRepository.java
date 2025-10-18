package dz.tarbiya.madrassa.adapter.out.jpa.personnel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelJpaRepository extends JpaRepository<PersonnelEntity, Long> {
}