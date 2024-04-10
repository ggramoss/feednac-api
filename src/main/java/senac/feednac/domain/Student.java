package senac.feednac.domain;

public class Student {
    private long id;
    private String name;
    private Course course;

    public Student(long id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }
}
