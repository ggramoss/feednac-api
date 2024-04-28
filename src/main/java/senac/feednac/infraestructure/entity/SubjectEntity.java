package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

@Entity(name = "disciplina")
public class SubjectEntity {

    @Id
    @Column(name = "dsp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private TeacherEntity teacher;

    @Column(name = "nome")
    private String name;

    @Deprecated
    public SubjectEntity() {}

    public Long getId() {
        return id;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public String getName() {
        return name;
    }
}
