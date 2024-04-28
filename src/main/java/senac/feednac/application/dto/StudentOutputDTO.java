package senac.feednac.application.dto;

public record StudentOutputDTO(
        long id, String name, String email, Boolean status, String dateOfBirth, String telephone, CourseOutputDTO course
) {}
