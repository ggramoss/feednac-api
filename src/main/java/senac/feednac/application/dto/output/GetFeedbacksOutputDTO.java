package senac.feednac.application.dto.output;

import java.util.List;

public class GetFeedbacksOutputDTO {
    private List<FeedbackDTO> feedbacks;

    public GetFeedbacksOutputDTO(List<FeedbackDTO> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<FeedbackDTO> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<FeedbackDTO> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
