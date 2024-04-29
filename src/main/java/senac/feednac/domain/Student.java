package senac.feednac.domain;

public class Student {
    private long id;
    private String name;
    private String email;
    private Boolean status;
    private String dateOfBirth;
    private String telephone;
    private Course course;
    private Class aClass;

    public Student(
            long id,
            String name,
            String email,
            Boolean status,
            String dateOfBirth,
            String telephone,
            Course course,
            Class aClass
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
        this.course = course;
        this.aClass = aClass;
    }

    public long getId() {
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

    public Course getCourse() {
        return course;
    }

    public Class getaClass() {
        return aClass;
    }
}
