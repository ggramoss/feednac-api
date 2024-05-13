package senac.feednac.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.feednac.infraestructure.entity.DailyScheduleEntity;

import java.util.List;
import java.util.Optional;

public interface DailyScheduleJpaRepository extends JpaRepository<DailyScheduleEntity, Long> {

    Optional<List<DailyScheduleEntity>> findByCourseSession_Subject_Teacher_Id(Long teacherId);
}
