package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

@Entity(name = "cronogramadiario_estudante")
public class StudentDailyScheduleEntity {

    @Id
    @Column(name = "cronogramadiario_estudante_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "semestre")
    private String semestre;

    @ManyToOne
    @JoinColumn(name = "estudante_id", referencedColumnName = "est_id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "cronograma_diario_id", referencedColumnName = "crd_id")
    private DailyScheduleEntity dailySchedule;

    @Deprecated
    public StudentDailyScheduleEntity() {}

    public Long getId() {
        return id;
    }

    public String getSemestre() {
        return semestre;
    }

    public StudentEntity getStudentEntity() {
        return student;
    }

    public DailyScheduleEntity getDailySchedule() {
        return dailySchedule;
    }
}
