package senac.feednac.infraestructure.converter;

import senac.feednac.domain.Calendar;
import senac.feednac.domain.DailySchedule;
import senac.feednac.infraestructure.entity.CalendarEntity;

import java.util.ArrayList;

public class CalendarEntityConverter {

    public static Calendar toCalendar(CalendarEntity entity) {
        var student = StudentEntityConverter.toStudent(entity.getStudentEntity());
        var dailySchedules = new ArrayList<DailySchedule>();

        entity.getDailySchedules().forEach(dailyScheduleEntity -> {
           var courseSession = CourseSessionEntityConverter.toCourseSession(dailyScheduleEntity.getCourseSession());

            dailySchedules.add(
                    new DailySchedule(dailyScheduleEntity.getDayOfWeek(), courseSession)
            );
        });

        return new Calendar(
                entity.getId(),
                entity.getSemestre(),
                student,
                dailySchedules
        );
    }
}
