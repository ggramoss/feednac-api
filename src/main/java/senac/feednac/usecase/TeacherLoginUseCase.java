package senac.feednac.usecase;

import org.springframework.stereotype.Service;
import senac.feednac.application.dto.TeacherLoginInputDTO;
import senac.feednac.domain.Teacher;
import senac.feednac.infraestructure.repository.TeacherRepository;

import java.util.Base64;

import static java.util.Objects.isNull;

@Service
public class TeacherLoginUseCase {

    private TeacherRepository repository;

    public TeacherLoginUseCase(TeacherRepository repository) {
        this.repository = repository;
    }

    public Teacher login (TeacherLoginInputDTO dto) {
        if (isNull(dto) || isNull(dto.username()) || dto.username().isEmpty() || isNull(dto.passwordEncrypted()) || dto.passwordEncrypted().isEmpty()) {
            return null;
        }

        var passwordText = new String(Base64.getDecoder().decode(dto.passwordEncrypted()));
        return repository.findIdByUsernameAndPassword(dto.username(), passwordText);
    }
}
