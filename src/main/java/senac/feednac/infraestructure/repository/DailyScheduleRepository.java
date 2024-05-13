package senac.feednac.infraestructure.repository;

import org.springframework.stereotype.Service;
import senac.feednac.domain.DailySchedule;
import senac.feednac.infraestructure.converter.DailyScheduleEntityConverter;

import java.util.List;

@Service
public class DailyScheduleRepository {

    private DailyScheduleJpaRepository jpaRepository;

    public DailyScheduleRepository(DailyScheduleJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<DailySchedule> getTeacherDailyScheduleByTeacherId(Long teacherId) {
        var dailySchedules = jpaRepository.findByCourseSession_Subject_Teacher_Id(teacherId);
        return dailySchedules.map(DailyScheduleEntityConverter::toDailySchedules).orElse(null);
    }
}
