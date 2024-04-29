package senac.feednac.application.converter;

import senac.feednac.application.dto.DailyScheduleOutputDTO;
import senac.feednac.domain.DailySchedule;

public class DailyScheduleConverter {

    public static DailyScheduleOutputDTO toDailyScheduleOutputDTO(DailySchedule dailySchedule) {
        var courseSessionDTO = CourseSessionConverter.toCourseSessionOutputDTO(dailySchedule.getCourseSession());

        return new DailyScheduleOutputDTO(
                dailySchedule.getDayOfWeek().getName(),
                courseSessionDTO
        );
    }
}
