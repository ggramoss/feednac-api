package senac.feednac.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.feednac.infraestructure.entity.StudentEntity;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {
}
