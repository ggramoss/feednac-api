package senac.feednac.application.dto.input;

public record TeacherLoginInputDTO (
        String username, String passwordEncrypted
) {
}
