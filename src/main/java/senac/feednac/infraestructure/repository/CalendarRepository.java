package senac.feednac.infraestructure.repository;

import org.springframework.stereotype.Service;
import senac.feednac.domain.Calendar;
import senac.feednac.infraestructure.converter.CalendarEntityConverter;

@Service
public class CalendarRepository {

    private CalendarJpaRepository jpaRepository;

    public CalendarRepository(CalendarJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Calendar getCalendarByStudentId(Long studentId) {
        var calendarEntity = jpaRepository.findByStudentEntity_Id(studentId);
        return calendarEntity.map(CalendarEntityConverter::toCalendar).orElse(null);
    }
}
