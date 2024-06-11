package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity(name = "pergunta")
public class QuestionEntity {

    @Id
    @Column(name = "per_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "question")
    private List<AnswerOptionEntity> options;

    @Column(name = "valor")
    private String value;

    @Deprecated
    public QuestionEntity() {
    }

    public Long getId() {
        return id;
    }

    public List<AnswerOptionEntity> getOptions() {
        return options;
    }

    public String getValue() {
        return value;
    }

}
