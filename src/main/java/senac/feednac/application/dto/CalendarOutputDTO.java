package senac.feednac.application.dto;

import java.util.List;

public record CalendarOutputDTO(
        String semester, List<DailyScheduleOutputDTO> dailySchedules
) {}
