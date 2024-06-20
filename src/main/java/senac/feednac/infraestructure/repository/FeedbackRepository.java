package senac.feednac.infraestructure.repository;

import org.springframework.stereotype.Service;
import senac.feednac.domain.Feedback;
import senac.feednac.infraestructure.converter.FeedbackEntityConverter;

import java.util.List;

@Service
public class FeedbackRepository {

    private FeedbackJPARepository jpaRepository;

    public FeedbackRepository(
            FeedbackJPARepository jpaRepository
    ) {
        this.jpaRepository = jpaRepository;
    }

    public List<Feedback> findByCourseSessionIdAndTeacherId(Long courseSessionId, Long teacherId) {
        var feedbacksEntity = jpaRepository.findByCourseSessionIdAndCourseSession_Subject_Teacher_Id(courseSessionId, teacherId);
        return FeedbackEntityConverter.toFeedbacks(feedbacksEntity);
    }

    public Long save(Feedback feedback) {
        var feedbackEntity = FeedbackEntityConverter.toFeedbackEntity(feedback);
        feedbackEntity = this.jpaRepository.save(feedbackEntity);
        return feedbackEntity.getId();
    }
}
