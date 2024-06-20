package senac.feednac.application.dto.output;

import java.util.List;

public class FeedbackDTO {
    private Long id;
    private Long generalNote;
    private String additionalComment;
    private List<AnsweredQuestionDTO> answeredQuestions;

    public FeedbackDTO(Long id, Long generalNote, String additionalComment, List<AnsweredQuestionDTO> answeredQuestions) {
        this.id = id;
        this.generalNote = generalNote;
        this.additionalComment = additionalComment;
        this.answeredQuestions = answeredQuestions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGeneralNote() {
        return generalNote;
    }

    public void setGeneralNote(Long generalNote) {
        this.generalNote = generalNote;
    }

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }

    public List<AnsweredQuestionDTO> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<AnsweredQuestionDTO> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }
}
