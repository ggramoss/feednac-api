package senac.feednac.usecase;

import org.springframework.stereotype.Component;
import senac.feednac.domain.DailySchedule;
import senac.feednac.infraestructure.repository.DailyScheduleRepository;

import java.util.List;

@Component
public class FindTeacherDailyScheduleByTeacherId {

    private DailyScheduleRepository dailyScheduleRepository;

    public FindTeacherDailyScheduleByTeacherId(DailyScheduleRepository dailyScheduleRepository) {
        this.dailyScheduleRepository = dailyScheduleRepository;
    }

    public List<DailySchedule> find(Long teacherId) {
        return dailyScheduleRepository.getTeacherDailyScheduleByTeacherId(teacherId);
    }
}
