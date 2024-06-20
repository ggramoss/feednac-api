package senac.feednac.usecase.converter;

import org.springframework.stereotype.Service;
import senac.feednac.application.dto.input.CreateFeedbackInputDTO;
import senac.feednac.domain.Answer;
import senac.feednac.domain.Feedback;
import senac.feednac.infraestructure.repository.CourseSessionRepository;

@Service
public class FeedbackConverter {

    private CourseSessionRepository courseSessionRepository;

    public FeedbackConverter(CourseSessionRepository courseSessionRepository) {
        this.courseSessionRepository = courseSessionRepository;
    }

    public Feedback createFeedback(CreateFeedbackInputDTO dto) {
        var courseSession = this.courseSessionRepository.findById(dto.courseSessionId());
        return new Feedback(
                null,
                courseSession,
                null,
                dto.generalNote(),
                dto.additionalComment()
        );
    }
}
