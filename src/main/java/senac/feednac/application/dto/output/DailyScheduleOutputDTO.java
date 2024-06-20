package senac.feednac.application.dto.output;

public record DailyScheduleOutputDTO(
       String dayOfWeek, CourseSessionOutputDTO courseSession
){}
