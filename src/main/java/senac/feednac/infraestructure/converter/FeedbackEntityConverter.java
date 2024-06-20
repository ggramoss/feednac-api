package senac.feednac.infraestructure.converter;

import senac.feednac.domain.Feedback;
import senac.feednac.infraestructure.entity.FeedbackEntity;

import java.util.List;

public class FeedbackEntityConverter {

    public static FeedbackEntity toFeedbackEntity(Feedback feedback) {
        return new FeedbackEntity(
                feedback.getId(),
                feedback.getCourseSession().getId(),
                feedback.getDate(),
                feedback.getGeneralNote(),
                feedback.getAdditionalComment()
        );
    }

    public static Feedback toFeedback(FeedbackEntity feedbackEntity) {
        return new Feedback(
                feedbackEntity.getId(),
                CourseSessionEntityConverter.toCourseSession(feedbackEntity.getCourseSession()),
                feedbackEntity.getDate(),
                feedbackEntity.getGeneralNote(),
                feedbackEntity.getAdditionalComment()
        );
    }

    public static List<Feedback> toFeedbacks(List<FeedbackEntity> feedbacksEntity) {
        return feedbacksEntity.stream().map(FeedbackEntityConverter::toFeedback).toList();
    }
}
