package senac.feednac.domain;

import java.util.List;

public class Calendar {

    private Long id;
    private String semester;
    private Student student;
    private List<DailySchedule> dailySchedules;

    public Calendar(Long id, String semester, Student student, List<DailySchedule> dailySchedules) {
        this.id = id;
        this.student = student;
        this.semester = semester;
        this.dailySchedules = dailySchedules;
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

    public List<DailySchedule> getDailySchedules() {
        return dailySchedules;
    }
}
