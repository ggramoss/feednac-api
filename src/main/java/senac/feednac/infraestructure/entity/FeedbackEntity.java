package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "feedback")
public class FeedbackEntity {

    @Id
    @Column(name = "fdb_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aula_id", referencedColumnName = "aul_id")
    private CourseSessionEntity courseSession;

    @Column(name = "data")
    private Date date;

    @Column(name = "nota_geral")
    private Long generalNote;

    @OneToMany(mappedBy = "feedback")
    private List<AnswerEntity> answers;

    @Column(name = "comentario_adicional")
    private String additionalComment;


}
