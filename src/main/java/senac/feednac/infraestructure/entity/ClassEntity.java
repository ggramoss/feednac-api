package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

@Entity(name = "turma")
public class ClassEntity {

    @Id
    @Column(name = "tur_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Deprecated
    public ClassEntity() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
