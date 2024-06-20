package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

@Entity(name = "resposta_pergunta")
public class AnswerEntity {

    @Id
    @Column(name = "rsp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feedback_id")
    private Long feedbackId;

    @ManyToOne
    @JoinColumn(name = "feedback_id", insertable = false, updatable=false)
    private FeedbackEntity feedback;

    @Column(name = "pergunta_id")
    private Long questionId;

    @OneToOne
    @JoinColumn(name = "pergunta_id", insertable = false, updatable=false)
    private QuestionEntity question;

    @Column(name = "opcao_id")
    private Long optionId;

    @ManyToOne
    @JoinColumn(name = "opcao_id", insertable = false, updatable=false)
    private AnswerOptionEntity option;

    @Deprecated
    public AnswerEntity() {}

    public AnswerEntity(
            Long id,
            Long feedbackId,
            Long questionId,
            Long optionId
    ) {
        this.id = id;
        this.feedbackId = feedbackId;
        this.questionId = questionId;
        this.optionId = optionId;
    }

    public AnswerEntity(
            Long id,
            Long feedbackId,
            FeedbackEntity feedback,
            Long questionId,
            QuestionEntity question,
            Long optionId,
            AnswerOptionEntity option
    ) {
        this.id = id;
        this.feedbackId = feedbackId;
        this.feedback = feedback;
        this.questionId = questionId;
        this.question = question;
        this.optionId = optionId;
        this.option = option;
    }

    public Long getId() {
        return id;
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public FeedbackEntity getFeedback() {
        return feedback;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public Long getOptionId() {
        return optionId;
    }

    public AnswerOptionEntity getOption() {
        return option;
    }
}
