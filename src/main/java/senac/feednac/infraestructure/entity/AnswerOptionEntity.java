package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

@Entity(name = "opcao_resposta")
public class AnswerOptionEntity {

    @Id
    @Column(name = "opr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pergunta_id", referencedColumnName = "per_id")
    private QuestionEntity question;

    @Column(name = "valor")
    private String option;

    @Deprecated
    public AnswerOptionEntity() {}

    public Long getId() {
        return id;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public String getOption() {
        return option;
    }
}
