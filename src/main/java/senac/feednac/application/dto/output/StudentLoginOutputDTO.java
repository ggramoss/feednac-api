package senac.feednac.application.dto.output;

public record StudentLoginOutputDTO(
        long id, String name, String email, Boolean status, String dateOfBirth, String telephone, CourseOutputDTO course
) {}
