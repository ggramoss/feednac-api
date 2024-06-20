package senac.feednac.infraestructure.repository;

import org.springframework.stereotype.Service;
import senac.feednac.domain.Answer;
import senac.feednac.infraestructure.converter.AnswerEntityConverter;

import java.util.List;

@Service
public class AnswerRepository {

    private AnswerJPARepository jpaRepository;

    public AnswerRepository(AnswerJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public void saveAll(List<Answer> answers) {
        var answerEntities = AnswerEntityConverter.toAnswerEntities(answers);
        this.jpaRepository.saveAll(answerEntities);
    }

    public List<Answer> findByFeedbackIds(List<Long> feedbackIds) {
        var answers = this.jpaRepository.findAnswerEntitiesByFeedbackIdIn(feedbackIds);
        return AnswerEntityConverter.toAnswers(answers);
    }
}
