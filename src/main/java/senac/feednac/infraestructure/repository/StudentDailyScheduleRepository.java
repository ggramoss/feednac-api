package senac.feednac.infraestructure.repository;

import org.springframework.stereotype.Service;
import senac.feednac.domain.StudentDailySchedule;
import senac.feednac.infraestructure.converter.StudentDailyScheduleEntityConverter;

import java.util.List;

@Service
public class StudentDailyScheduleRepository {

    private StudentDailyScheduleJpaRepository jpaRepository;

    public StudentDailyScheduleRepository(StudentDailyScheduleJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<StudentDailySchedule> getStudentDailySchedulesByStudentId(Long studentId) {
        var studentDailySchedules = jpaRepository.findByStudent_Id(studentId);
        return studentDailySchedules.map(StudentDailyScheduleEntityConverter::toStudentDailyScheduleList).orElse(null);
    }
}
