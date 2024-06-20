package senac.feednac.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.feednac.infraestructure.entity.AnswerOptionEntity;

public interface AnswerOptionJPARepository extends JpaRepository<AnswerOptionEntity, Long> {
}
