package senac.feednac.usecase.converter;

import org.springframework.stereotype.Service;
import senac.feednac.application.dto.input.QuestionAnswered;
import senac.feednac.domain.Answer;
import senac.feednac.domain.AnswerOption;
import senac.feednac.domain.Feedback;
import senac.feednac.domain.Question;
import senac.feednac.infraestructure.repository.QuestionRepository;

import java.util.*;

@Service
public class AnswerConverter {

    private QuestionRepository questionRepository;

    public AnswerConverter(
            QuestionRepository questionRepository
    ) {
        this.questionRepository = questionRepository;
    }

    public List<Answer> createAnswer (Feedback feedback, List<QuestionAnswered> questionsAnswered) {
        Map<Question, AnswerOption> questionAnswerOptionMap = new HashMap<>(questionsAnswered.size());
        questionsAnswered.forEach(questionAnswered -> {
            var question = this.questionRepository.findById(questionAnswered.questionId());
            var option = question.getOptions()
                    .stream()
                    .filter(questionOption -> Objects.equals(questionOption.getId(), questionAnswered.optionId()))
                    .findFirst()
                    .orElseThrow();
            questionAnswerOptionMap.put(question, option);
        });

        var answers = new ArrayList<Answer>();
        questionAnswerOptionMap.forEach((question, answerOption) -> {
            var answer = new Answer(
                    null,
                    feedback,
                    question,
                    answerOption
            );
            answers.add(answer);
        });

        return answers;
    }
}
