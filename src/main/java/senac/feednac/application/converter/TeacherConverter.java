package senac.feednac.application.converter;

import senac.feednac.application.dto.TeacherLoginOutputDTO;
import senac.feednac.domain.Subject;
import senac.feednac.domain.Teacher;

public class TeacherConverter {

    public static TeacherLoginOutputDTO toTeacherLoginOutputDTO (Teacher teacher) {
        var subjectNames = teacher.getSubjects().stream().map(Subject::getName).toList();

        return new TeacherLoginOutputDTO(
                teacher.getId(),
                teacher.getName(),
                teacher.getEmail(),
                teacher.getTelephone(),
                subjectNames
        );
    }
}
