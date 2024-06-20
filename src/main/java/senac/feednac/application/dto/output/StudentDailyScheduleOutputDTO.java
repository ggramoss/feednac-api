package senac.feednac.application.dto.output;

public record StudentDailyScheduleOutputDTO(
        String semester, DailyScheduleOutputDTO dailySchedule
) {}
