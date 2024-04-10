package senac.feednac.infraestructure.converter;

import senac.feednac.domain.Course;
import senac.feednac.domain.Student;
import senac.feednac.infraestructure.entity.StudentEntity;

public class StudentEntityConverter {

    public static Student toStudent(StudentEntity student) {
        var course = new Course(
                student.getCourse().getId(),
                student.getCourse().getName(),
                student.getCourse().getCategory()
        );
        return new Student(
                student.getId(),
                student.getName(),
                course
        );
    }
}
