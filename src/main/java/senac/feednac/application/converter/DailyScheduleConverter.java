package senac.feednac.application.converter;

import senac.feednac.application.dto.output.DailyScheduleOutputDTO;
import senac.feednac.domain.DailySchedule;

import java.util.List;
import java.util.Objects;

public class DailyScheduleConverter {

    public static DailyScheduleOutputDTO toDailyScheduleOutputDTO(DailySchedule dailySchedule) {
        var courseSessionDTO = CourseSessionConverter.toCourseSessionOutputDTO(dailySchedule.getCourseSession());

        return new DailyScheduleOutputDTO(
                dailySchedule.getDayOfWeek().getName(),
                courseSessionDTO
        );
    }

    public static List<DailyScheduleOutputDTO> toDailySchedulesOutputDTO(List<DailySchedule> dailySchedules) {
        if (Objects.isNull(dailySchedules) || dailySchedules.isEmpty()) {
            return List.of();
        }

        return dailySchedules.stream().map(DailyScheduleConverter::toDailyScheduleOutputDTO).toList();
    }
}
