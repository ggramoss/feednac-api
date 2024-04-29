package senac.feednac.domain;

public class DailySchedule {
    private DayOfWeek dayOfWeek;
    private CourseSession courseSession;

    public DailySchedule(Long dayOfWeek, CourseSession courseSession) {
        this.dayOfWeek = DayOfWeek.getDayOfWeekById(dayOfWeek);
        this.courseSession = courseSession;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public CourseSession getCourseSession() {
        return courseSession;
    }
}
