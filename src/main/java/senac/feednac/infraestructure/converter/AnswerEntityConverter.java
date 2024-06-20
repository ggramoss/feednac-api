package senac.feednac.infraestructure.converter;

import senac.feednac.domain.Answer;
import senac.feednac.infraestructure.entity.AnswerEntity;

import java.util.List;

public class AnswerEntityConverter {

    public static AnswerEntity toAnswerEntity(Answer answer) {
        return new AnswerEntity(
                answer.getId(),
                answer.getFeedback().getId(),
                answer.getQuestion().getId(),
                answer.getOption().getId()
        );
    }

    public static List<AnswerEntity> toAnswerEntities(List<Answer> answers) {
        return answers.stream().map(AnswerEntityConverter::toAnswerEntity).toList();
    }

    public static Answer toAnswer(AnswerEntity entity) {
        return new Answer(
                entity.getId(),
                FeedbackEntityConverter.toFeedback(entity.getFeedback()),
                QuestionEntityConverter.toQuestion(entity.getQuestion()),
                AnswerOptionEntityConverter.toAnswerOption(entity.getOption())
        );
    }

    public static List<Answer> toAnswers(List<AnswerEntity> answers) {
        return answers.stream().map(AnswerEntityConverter::toAnswer).toList();
    }
}
