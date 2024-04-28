package senac.feednac.domain;

import java.util.List;

public class Teacher {

    private Long id;

    private String name;

    private String email;

    private String username;

    private String password;

    private String telephone;

    private List<Subject> subjects;

    public Teacher(Long id, String name, String email, String username, String password, String telephone, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.subjects = subjects;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
