package senac.feednac.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.feednac.infraestructure.entity.AnswerEntity;

import java.util.List;

@Repository
public interface AnswerJPARepository extends JpaRepository<AnswerEntity, Long> {

    List<AnswerEntity> findAnswerEntitiesByFeedbackIdIn(List<Long> feedbackId);
}
