package senac.feednac.domain;

public class CourseSession {

    private Long id;
    private String duration;
    private String startTime;
    private String endTime;
    private Long classRoom;
    private Long flat;
    private Teacher teacher;
    private Subject subject;
    private Class aClass;

    public CourseSession(
            Long id,
            String duration,
            String startTime,
            String endTime,
            Long classRoom,
            Long flat,
            Teacher teacher,
            Subject subject,
            Class aClass
    ) {
        this.id = id;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classRoom = classRoom;
        this.flat = flat;
        this.teacher = teacher;
        this.subject = subject;
        this.aClass = aClass;
    }

    public Long getId() {
        return id;
    }

    public String getDuration() {
        return duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Long getClassRoom() {
        return classRoom;
    }

    public Long getFlat() {
        return flat;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public Class getaClass() {
        return aClass;
    }
}
