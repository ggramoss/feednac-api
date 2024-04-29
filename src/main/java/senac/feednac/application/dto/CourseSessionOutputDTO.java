package senac.feednac.application.dto;

public record CourseSessionOutputDTO(
    String duration,
    String startTime,
    String endTime,
    Long classRoom,
    Long flat,
    String teacherName,
    String subjectName,
    String className
) {}
