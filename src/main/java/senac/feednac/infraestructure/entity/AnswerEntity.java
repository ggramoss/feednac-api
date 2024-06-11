package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

@Entity(name = "resposta_pergunta")
public class AnswerEntity {

    @Id
    @Column(name = "rsp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "feedback_id", referencedColumnName = "fdb_id")
    private FeedbackEntity feedback;

    @OneToOne
    @JoinColumn(name = "pergunta_id", referencedColumnName = "per_id")
    private QuestionEntity question;

    @ManyToOne
    @JoinColumn(name = "opcao_id", referencedColumnName = "opr_id")
    private AnswerOptionEntity option;

    @Column(name = "valor")
    private String value;

    @Deprecated
    public AnswerEntity() {}

    public Long getId() {
        return id;
    }

}
