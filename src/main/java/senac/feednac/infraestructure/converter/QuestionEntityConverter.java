package senac.feednac.infraestructure.converter;

import senac.feednac.domain.Question;
import senac.feednac.infraestructure.entity.QuestionEntity;

import java.util.List;

public class QuestionEntityConverter {

    public static List<Question> toQuestion (List<QuestionEntity> questionEntityList) {
        return questionEntityList.stream().map(entity -> {
            var opDomain = AnswerOptionEntityConverter.toAnswerOptions(entity.getOptions());

            return new Question(
                    entity.getId(),
                    opDomain,
                    entity.getValue()
            );
        }).toList();
    }
}
