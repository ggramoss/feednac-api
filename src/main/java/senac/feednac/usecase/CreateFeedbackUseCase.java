package senac.feednac.usecase;

import org.springframework.stereotype.Service;
import senac.feednac.application.dto.input.CreateFeedbackInputDTO;
import senac.feednac.infraestructure.repository.AnswerRepository;
import senac.feednac.infraestructure.repository.FeedbackRepository;
import senac.feednac.usecase.converter.AnswerConverter;
import senac.feednac.usecase.converter.FeedbackConverter;

@Service
public class CreateFeedbackUseCase {

    private FeedbackConverter feedbackConverter;
    private AnswerConverter answerConverter;
    private FeedbackRepository feedbackRepository;
    private AnswerRepository answerRepository;

    public CreateFeedbackUseCase(
            FeedbackConverter feedbackConverter,
            AnswerConverter answerConverter,
            FeedbackRepository feedbackRepository,
            AnswerRepository answerRepository
    ) {
        this.feedbackConverter = feedbackConverter;
        this.answerConverter = answerConverter;
        this.feedbackRepository = feedbackRepository;
        this.answerRepository = answerRepository;
    }

    public void create(CreateFeedbackInputDTO dto) {
        var feedback = this.feedbackConverter.createFeedback(dto);
        var feedbackId = this.feedbackRepository.save(feedback);
        feedback.setId(feedbackId);
        var answers = this.answerConverter.createAnswer(feedback, dto.questionsAnswered());
        this.answerRepository.saveAll(answers);
    }
}
