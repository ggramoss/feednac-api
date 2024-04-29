package senac.feednac.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.feednac.infraestructure.entity.CalendarEntity;

import java.util.Optional;

@Repository
public interface CalendarJpaRepository extends JpaRepository<CalendarEntity, Long> {

    Optional<CalendarEntity> findByStudentEntity_Id(Long studentEntity_id);
}
