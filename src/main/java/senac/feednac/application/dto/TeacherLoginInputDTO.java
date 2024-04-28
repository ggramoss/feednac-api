package senac.feednac.application.dto;

public record TeacherLoginInputDTO (
        String username, String passwordEncrypted
) {
}
