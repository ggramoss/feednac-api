package senac.feednac.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.feednac.infraestructure.entity.FeedbackEntity;

import java.util.List;

@Repository
public interface FeedbackJPARepository extends JpaRepository<FeedbackEntity, Long> {

    List<FeedbackEntity> findByCourseSessionIdAndCourseSession_Subject_Teacher_Id(Long courseSessionId, Long courseSession_subject_teacher_id);
}
