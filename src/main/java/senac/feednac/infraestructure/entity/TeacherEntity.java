package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "professor")
public class TeacherEntity {

    @Id
    @Column(name = "prf_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "usuario")
    private String username;

    @Column(name = "senha")
    private String password;

    @Column(name = "telefone")
    private String telephone;

    @OneToMany(mappedBy = "teacher")
    private List<SubjectEntity> subject;

    @Deprecated
    public TeacherEntity() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public List<SubjectEntity> getSubject() {
        return subject;
    }
}