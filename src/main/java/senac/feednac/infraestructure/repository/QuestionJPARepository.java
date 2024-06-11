package senac.feednac.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.feednac.infraestructure.entity.QuestionEntity;

@Repository
public interface QuestionJPARepository extends JpaRepository<QuestionEntity, Long> {
}
