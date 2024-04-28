package senac.feednac.infraestructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "curso")
public class CourseEntity {

    @Id
    @Column(name = "cur_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "categoria")
    private int category;

    @Deprecated
    public CourseEntity() {
    }

    public CourseEntity(long id, String name, int category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }
}
