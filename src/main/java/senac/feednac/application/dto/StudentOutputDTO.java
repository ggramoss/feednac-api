package senac.feednac.application.dto;

public record StudentOutputDTO(
        long id, String name, CourseOutputDTO course
) {}
