package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

@Entity(name = "cronograma_diario")
public class DailyScheduleEntity {

    @Id
    @Column(name = "crd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dia_semana")
    private Long dayOfWeek;

    @ManyToOne
    @JoinColumn(name = "aula_id", referencedColumnName = "aul_id")
    private CourseSessionEntity courseSession;

    @Deprecated
    public DailyScheduleEntity() {}

    public Long getId() {
        return id;
    }

    public Long getDayOfWeek() {
        return dayOfWeek;
    }

    public CourseSessionEntity getCourseSession() {
        return courseSession;
    }

}
