package senac.feednac.infraestructure.converter;

import senac.feednac.domain.CourseSession;
import senac.feednac.infraestructure.entity.CourseSessionEntity;

public class CourseSessionEntityConverter {

    public static CourseSession toCourseSession (CourseSessionEntity entity) {
        var subject = SubjectEntityConverter.toSubject(entity.getSubject());
        var teacher = TeacherEntityConverter.toTeacher(entity.getSubject().getTeacher());
        var aClass = ClassEntityConverter.toClass(entity.getaClass());

        return new CourseSession(
                entity.getId(),
                entity.getDuration(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getClassRoom(),
                entity.getFlat(),
                teacher,
                subject,
                aClass
        );
    }
}
