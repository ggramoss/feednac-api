package senac.feednac.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.feednac.infraestructure.entity.CourseSessionEntity;

@Repository
public interface CourseSessionJPARepository extends JpaRepository<CourseSessionEntity, Long> {
}
