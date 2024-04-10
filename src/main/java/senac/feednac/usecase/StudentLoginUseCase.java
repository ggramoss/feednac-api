package senac.feednac.usecase;

import org.springframework.stereotype.Service;
import senac.feednac.domain.Course;
import senac.feednac.domain.CourseCategory;
import senac.feednac.domain.Student;
import senac.feednac.infraestructure.repository.StudentRepository;

import java.util.Objects;

@Service
public class StudentLoginUseCase {

    private StudentRepository repository;

    public StudentLoginUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public Student login(long id) {
        return repository.findById(id);
    }
}
