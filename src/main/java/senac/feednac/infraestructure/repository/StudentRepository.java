package senac.feednac.infraestructure.repository;

import org.springframework.stereotype.Service;
import senac.feednac.domain.Student;
import senac.feednac.infraestructure.converter.StudentEntityConverter;

@Service
public class StudentRepository {

    private StudentJpaRepository jpaRepository;

    public StudentRepository(StudentJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Student findById(long id) {
        var studentEntity = jpaRepository.findById(id);
        return studentEntity.map(StudentEntityConverter::toStudent).orElse(null);
    }
}
