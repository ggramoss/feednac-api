package senac.feednac.application.converter;

import senac.feednac.application.dto.output.AnswerOptionOutputDTO;
import senac.feednac.application.dto.output.GetQuestionsOutputDTO;
import senac.feednac.application.dto.output.QuestionOutputDTO;
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
