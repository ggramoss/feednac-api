package senac.feednac.domain;

import java.util.List;

public class ClassSchedule {

    private Student student;
    private String semester;
    private List<Schedule> schedules;

    public ClassSchedule(Student student, String semester, List<Schedule> schedules) {
        this.student = student;
        this.semester = semester;
        this.schedules = schedules;
    }

    public Student getStudent() {
        return student;
    }

    public String getSemester() {
        return semester;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
