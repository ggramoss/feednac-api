package senac.feednac.application.converter;

import senac.feednac.application.dto.CourseOutputDTO;
import senac.feednac.application.dto.StudentOutputDTO;
import senac.feednac.domain.Student;

public class StudentConverter {

    public static StudentOutputDTO toStudentOutputDTO(Student student) {
        var course = new CourseOutputDTO(student.getCourse().getName(), student.getCourse().getCategory().getName());
        return new StudentOutputDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getStatus(),
                student.getDateOfBirth(),
                student.getTelephone(),
                course
        );
    }
}
