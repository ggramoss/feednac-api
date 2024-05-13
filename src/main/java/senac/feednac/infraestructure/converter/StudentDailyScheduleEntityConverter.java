package senac.feednac.infraestructure.converter;

import senac.feednac.domain.StudentDailySchedule;
import senac.feednac.infraestructure.entity.StudentDailyScheduleEntity;

import java.util.List;

public class StudentDailyScheduleEntityConverter {

    public static List<StudentDailySchedule> toStudentDailyScheduleList(List<StudentDailyScheduleEntity> entity) {
        return entity.stream().map(studentDailyScheduleEntity -> {
            var student = StudentEntityConverter.toStudent(studentDailyScheduleEntity.getStudentEntity());
            var dailySchedules = DailyScheduleEntityConverter.toDailySchedule(studentDailyScheduleEntity.getDailySchedule());

            return new StudentDailySchedule(
                    studentDailyScheduleEntity.getId(),
                    studentDailyScheduleEntity.getSemestre(),
                    student,
                    dailySchedules
            );
        }).toList();
    }
}
