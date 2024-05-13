package senac.feednac.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.feednac.infraestructure.entity.StudentDailyScheduleEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDailyScheduleJpaRepository extends JpaRepository<StudentDailyScheduleEntity, Long> {

    Optional<List<StudentDailyScheduleEntity>> findByStudent_Id(Long studentEntity_id);
}
