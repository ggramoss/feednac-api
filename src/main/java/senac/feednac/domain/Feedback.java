package senac.feednac.domain;

import java.util.Date;
import java.util.List;

public class Feedback {

    private Long id;
    private CourseSession courseSession;
    private Date date;
    private Long generalNote;
    private List<Answer> answer;
    private String additionalComment;

    public Feedback(Long id, CourseSession courseSession, Date date, Long generalNote, List<Answer> answer, String additionalComment) {
        this.id = id;
        this.courseSession = courseSession;
        this.date = date;
        this.generalNote = generalNote;
        this.answer = answer;
        this.additionalComment = additionalComment;
    }

    public Long getId() {
        return id;
    }

    public CourseSession getCourseSession() {
        return courseSession;
    }

    public Date getDate() {
        return date;
    }

    public Long getGeneralNote() {
        return generalNote;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public String getAdditionalComment() {
        return additionalComment;
    }
}
