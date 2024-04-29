package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

@Entity(name = "aula")
public class CourseSessionEntity {

    @Id
    @Column(name = "aul_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "duracao")
    private String duration;
    @Column(name = "hora_inicio")
    private String startTime;
    @Column(name = "hora_fim")
    private String endTime;
    @Column(name = "sala")
    private Long classRoom;
    @Column(name = "andar")
    private Long flat;
    @ManyToOne
    @JoinColumn(name = "disciplina_id", referencedColumnName = "dsp_id")
    private SubjectEntity subject;
    @ManyToOne
    @JoinColumn(name = "turma_id", referencedColumnName = "tur_id")
    private ClassEntity aClass;
    @Deprecated
    public CourseSessionEntity() {}

    public Long getId() {
        return id;
    }

    public String getDuration() {
        return duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Long getClassRoom() {
        return classRoom;
    }

    public Long getFlat() {
        return flat;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public ClassEntity getaClass() {
        return aClass;
    }
}
