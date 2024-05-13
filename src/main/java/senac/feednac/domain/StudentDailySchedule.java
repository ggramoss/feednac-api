package senac.feednac.domain;

public class StudentDailySchedule {

    private Long id;
    private String semester;
    private Student student;
    private DailySchedule dailySchedule;

    public StudentDailySchedule(Long id, String semester, Student student, DailySchedule dailySchedule) {
        this.id = id;
        this.student = student;
        this.semester = semester;
        this.dailySchedule = dailySchedule;
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public String getSemester() {
        return semester;
    }

    public DailySchedule getDailySchedule() {
        return dailySchedule;
    }
}
