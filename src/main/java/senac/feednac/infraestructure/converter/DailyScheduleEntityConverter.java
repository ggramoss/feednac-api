package senac.feednac.infraestructure.converter;

import senac.feednac.domain.DailySchedule;
import senac.feednac.infraestructure.entity.DailyScheduleEntity;

import java.util.List;

public class DailyScheduleEntityConverter {

    public static DailySchedule toDailySchedule (DailyScheduleEntity entity) {
        var courseSession = CourseSessionEntityConverter.toCourseSession(entity.getCourseSession());
        return new DailySchedule(entity.getDayOfWeek(),courseSession);
    }

    public static List<DailySchedule> toDailySchedules (List<DailyScheduleEntity> entities) {
       return entities.stream().map(DailyScheduleEntityConverter::toDailySchedule).toList();
    }
}
