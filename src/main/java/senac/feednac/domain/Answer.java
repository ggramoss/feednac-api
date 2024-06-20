package senac.feednac.domain;

public class Answer {
    private Long id;
    private Feedback feedback;
    private Question question;
    private AnswerOption option;

    public Answer(
            Long id,
            Feedback feedback,
            Question question,
            AnswerOption option
    ) {
        this.id = id;
        this.feedback = feedback;
        this.question = question;
        this.option = option;
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
}
