package senac.feednac.application.converter;

import senac.feednac.application.dto.output.AnsweredQuestionDTO;
import senac.feednac.application.dto.output.FeedbackDTO;
import senac.feednac.application.dto.output.GetFeedbacksOutputDTO;
import senac.feednac.domain.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FeedbackConverter {

    public static GetFeedbacksOutputDTO toGetFeedbackOutputDTO(List<Answer> answers) {
        var feedbackIds = answers.stream().map(answer -> answer.getFeedback().getId()).distinct().toList();
        var feedbackDTOs = new ArrayList<FeedbackDTO>();
        feedbackIds.forEach(feedbackId -> {
            var answeredQuestionsDTO = answers.stream()
                    .filter(answer -> Objects.equals(answer.getFeedback().getId(), feedbackId))
                    .map(answer -> new AnsweredQuestionDTO(answer.getQuestion().getValue(), answer.getOption().getOption()))
                    .toList();
            var feedbackAnswers = answers.stream().filter(answer -> answer.getFeedback().getId().equals(feedbackId)).findFirst();
            var feedbackDto = new FeedbackDTO(
                    feedbackId,
                    feedbackAnswers.get().getFeedback().getGeneralNote(),
                    feedbackAnswers.get().getFeedback().getAdditionalComment(),
                    answeredQuestionsDTO
            );
            feedbackDTOs.add(feedbackDto);
        });
        return new GetFeedbacksOutputDTO(feedbackDTOs);
    }
}