package senac.feednac.infraestructure.converter;

import senac.feednac.domain.Question;
import senac.feednac.infraestructure.entity.QuestionEntity;

import java.util.List;

public class QuestionEntityConverter {

    public static List<Question> toQuestions (List<QuestionEntity> questionEntityList) {
        return questionEntityList.stream().map(QuestionEntityConverter::toQuestion).toList();
    }

    public static Question toQuestion(QuestionEntity questionEntity) {
        var opDomain = AnswerOptionEntityConverter.toAnswerOptions(questionEntity.getOptions());

        return new Question(
                questionEntity.getId(),
                opDomain,
                questionEntity.getValue()
        );
    }
}
