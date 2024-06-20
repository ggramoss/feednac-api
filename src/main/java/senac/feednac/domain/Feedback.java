package senac.feednac.domain;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Feedback {

    private Long id;
    private CourseSession courseSession;
    private Date date;
    private Long generalNote;
    private String additionalComment;

    public Feedback(
            Long id,
            CourseSession courseSession,
            Date date,
            Long generalNote,
            String additionalComment
    ) {
        this.id = id;
        this.courseSession = courseSession;
        this.date = date == null ? Date.from(Instant.now()) : date;
        this.generalNote = generalNote;
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

    public String getAdditionalComment() {
        return additionalComment;
    }

    public void setId(Long feedbackId) {
        this.id = feedbackId;
    }
}
