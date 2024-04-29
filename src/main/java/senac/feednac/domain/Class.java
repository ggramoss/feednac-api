package senac.feednac.domain;

public class Class {

    private Long id;

    private String name;

    public Class(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
