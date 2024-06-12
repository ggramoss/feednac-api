package senac.feednac.application.converter;

import senac.feednac.application.dto.CourseSessionOutputDTO;
import senac.feednac.domain.CourseSession;

public class CourseSessionConverter {

    public static CourseSessionOutputDTO toCourseSessionOutputDTO(CourseSession courseSession) {
        return new CourseSessionOutputDTO(
                courseSession.getId(),
                courseSession.getDuration(),
                courseSession.getStartTime(),
                courseSession.getEndTime(),
                courseSession.getClassRoom(),
                courseSession.getFlat(),
                courseSession.getTeacher().getName(),
                courseSession.getSubject().getName(),
                courseSession.getaClass().getName()
        );
    }
}
