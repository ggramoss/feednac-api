package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "calendario")
public class CalendarEntity {

    @Id
    @Column(name = "cal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "semestre")
    private String semestre;

    @ManyToOne
    @JoinColumn(name = "estudante_id", referencedColumnName = "est_id")
    private StudentEntity studentEntity;

    @ManyToMany
    @JoinTable(
            name = "cronogramadiario_calendario",
            joinColumns = @JoinColumn(name = "calendario_id"),
            inverseJoinColumns = @JoinColumn(name = "cronograma_diario_id"))
    private List<DailyScheduleEntity> dailySchedules;

    @Deprecated
    public CalendarEntity() {}

    public Long getId() {
        return id;
    }

    public String getSemestre() {
        return semestre;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public List<DailyScheduleEntity> getDailySchedules() {
        return dailySchedules;
    }
}
