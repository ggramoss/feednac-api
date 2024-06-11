package senac.feednac.domain;

public class Answer {
    private Long id;
    private Feedback feedback;
    private Question question;
    private AnswerOption option;
    private String value;

    public Answer(
            Long id,
            Feedback feedback,
            Question questionId,
            AnswerOption option,
            String value
    ) {
        this.id = id;
        this.feedback = feedback;
        this.question = questionId;
        this.option = option;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public Question getQuestion() {
        return question;
    }

    public AnswerOption getOption() {
        return option;
    }

    public String getValue() {
        return value;
    }
}
