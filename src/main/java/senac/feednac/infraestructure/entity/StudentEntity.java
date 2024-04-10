package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estudante")
public class StudentEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private CourseEntity course;

    @Deprecated
    public StudentEntity() {
    }

    public StudentEntity(Long id, String name, CourseEntity course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CourseEntity getCourse() {
        return course;
    }
}
