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

    @Column(name = "aula_id")
    private Long courseSessionId;

    @ManyToOne
    @JoinColumn(name = "aula_id", insertable = false, updatable=false)
    private CourseSessionEntity courseSession;

    @Column(name = "data")
    private Date date;

    @Column(name = "nota_geral")
    private Long generalNote;

    @OneToMany(mappedBy = "feedback")
    private List<AnswerEntity> answers;

    @Column(name = "comentario_adicional")
    private String additionalComment;

    @Deprecated
    public FeedbackEntity() {}

    public FeedbackEntity(
            Long id,
            Long courseSessionId,
            Date date,
            Long generalNote,
            String additionalComment
    ) {
        this.id = id;
        this.courseSessionId = courseSessionId;
        this.date = date;
        this.generalNote = generalNote;
        this.additionalComment = additionalComment;
    }

    public FeedbackEntity(
            Long id,
            Long courseSessionId,
            CourseSessionEntity courseSession,
            Date date,
            Long generalNote,
            List<AnswerEntity> answers,
            String additionalComment
    ) {
        this.id = id;
        this.courseSessionId = courseSessionId;
        this.courseSession = courseSession;
        this.date = date;
        this.generalNote = generalNote;
        this.answers = answers;
        this.additionalComment = additionalComment;
    }

    public Long getId() {
        return id;
    }

    public Long getCourseSessionId() {
        return courseSessionId;
    }

    public CourseSessionEntity getCourseSession() {
        return courseSession;
    }

    public Date getDate() {
        return date;
    }

    public Long getGeneralNote() {
        return generalNote;
    }

    public List<AnswerEntity> getAnswers() {
        return answers;
    }

    public String getAdditionalComment() {
        return additionalComment;
    }
}
