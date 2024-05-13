package senac.feednac.usecase;

import org.springframework.stereotype.Service;
import senac.feednac.domain.StudentDailySchedule;
import senac.feednac.infraestructure.repository.StudentDailyScheduleRepository;

import java.util.List;

@Service
public class FindStudentDailyScheduleByStudentId {

    private StudentDailyScheduleRepository repository;

    public FindStudentDailyScheduleByStudentId(StudentDailyScheduleRepository repository) {
        this.repository = repository;
    }

    public List<StudentDailySchedule> find(Long studentId) {
        return repository.getStudentDailySchedulesByStudentId(studentId);
    }
}
