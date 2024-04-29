package senac.feednac.usecase;

import org.springframework.stereotype.Service;
import senac.feednac.domain.Calendar;
import senac.feednac.infraestructure.repository.CalendarRepository;

@Service
public class FindCalendarByStudentId {

    private CalendarRepository repository;

    public FindCalendarByStudentId(CalendarRepository repository) {
        this.repository = repository;
    }

    public Calendar find(Long studentId) {
        return repository.getCalendarByStudentId(studentId);
    }
}
