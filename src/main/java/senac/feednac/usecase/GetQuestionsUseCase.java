package senac.feednac.usecase;

import org.springframework.stereotype.Service;
import senac.feednac.domain.Question;
import senac.feednac.infraestructure.repository.QuestionRepository;

import java.util.List;

@Service
public class GetQuestionsUseCase {

    private QuestionRepository repository;

    public GetQuestionsUseCase(QuestionRepository repository) {
        this.repository = repository;
    }

    public List<Question> get() {
        return repository.getQuestions();
    }
}
