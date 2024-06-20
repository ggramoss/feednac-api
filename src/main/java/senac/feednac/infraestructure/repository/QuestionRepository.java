package senac.feednac.infraestructure.repository;

import org.springframework.stereotype.Service;
import senac.feednac.domain.Question;
import senac.feednac.infraestructure.converter.QuestionEntityConverter;

import java.util.List;

@Service
public class QuestionRepository {

    private QuestionJPARepository jpaRepository;

    public QuestionRepository(QuestionJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<Question> getQuestions() {
        return QuestionEntityConverter.toQuestions(jpaRepository.findAll());
    }

    public List<Question> findAllByIds(List<Long> ids) {
        var questions = this.jpaRepository.findAllById(ids);
        return QuestionEntityConverter.toQuestions(questions);
    }

    public Question findById(Long id) {
        var question = this.jpaRepository.findById(id);
        return question.map(QuestionEntityConverter::toQuestion).orElse(null);
    }
}
