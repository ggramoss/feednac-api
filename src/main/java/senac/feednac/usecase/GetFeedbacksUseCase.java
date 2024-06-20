package senac.feednac.usecase;

import org.springframework.stereotype.Service;
import senac.feednac.domain.Answer;
import senac.feednac.domain.Feedback;
import senac.feednac.infraestructure.repository.AnswerRepository;
import senac.feednac.infraestructure.repository.FeedbackRepository;

import java.util.List;

@Service
public class GetFeedbacksUseCase {

    private FeedbackRepository feedbackRepository;
    private AnswerRepository answerRepository;

    public GetFeedbacksUseCase(
            AnswerRepository answerRepository,
            FeedbackRepository feedbackRepository
    ) {
        this.answerRepository = answerRepository;
        this.feedbackRepository = feedbackRepository;
    }

    public List<Answer> getByTeacherIdAndCourseSessionId (Long teacherId, Long courseSessionId) {
        var feedbacks = this.feedbackRepository.findByCourseSessionIdAndTeacherId(courseSessionId, teacherId);
        var feedbackIds = feedbacks.stream().map(Feedback::getId).toList();
        return this.answerRepository.findByFeedbackIds(feedbackIds);
    }
}
