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
        return QuestionEntityConverter.toQuestion(jpaRepository.findAll());
    }
}
