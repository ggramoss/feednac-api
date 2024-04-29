package senac.feednac.application.converter;

import senac.feednac.application.dto.CalendarOutputDTO;
import senac.feednac.application.dto.DailyScheduleOutputDTO;
import senac.feednac.domain.Calendar;

import java.util.ArrayList;
import java.util.Objects;

public class CalendarConverter {

    public static CalendarOutputDTO calendarOutputDTO(Calendar calendar) {
        if (Objects.isNull(calendar)) {
            return null;
        }

        var dailySchedulesDTO = new ArrayList<DailyScheduleOutputDTO>();

        calendar.getDailySchedules().forEach(dailySchedule -> {
            var dailyScheduleDTO = DailyScheduleConverter.toDailyScheduleOutputDTO(dailySchedule);
            dailySchedulesDTO.add(dailyScheduleDTO);
        });

        return new CalendarOutputDTO(
                calendar.getSemester(),
                dailySchedulesDTO
        );
    }
}
