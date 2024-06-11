package senac.feednac.application.converter;

import senac.feednac.application.dto.AnswerOptionOutputDTO;
import senac.feednac.application.dto.GetQuestionsOutputDTO;
import senac.feednac.application.dto.QuestionOutputDTO;
import senac.feednac.domain.Question;

import java.util.List;

public class QuestionConverter {

    public static GetQuestionsOutputDTO toQuestionList(List<Question> questions) {
        var dtoQuestions = questions.stream().map(question -> {
            var options = question.getOptions().stream().map(option -> new AnswerOptionOutputDTO(
                    option.getId(), option.getOption()
            )).toList();

            return new QuestionOutputDTO(question.getId(), question.getValue(), options);
        }).toList();

        return new GetQuestionsOutputDTO(
                dtoQuestions
        );
    }
}
