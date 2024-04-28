package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estudante")
public class StudentEntity {

    @Id
    @Column(name = "est_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "data_nascimento")
    private String dateOfBirth;

    @Column(name = "telefone")
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "cur_id")
    private CourseEntity course;

    @ManyToOne
    @JoinColumn(name = "turma_id", referencedColumnName = "tur_id")
    private ClassEntity classEntity;

    @Deprecated
    public StudentEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }
}
