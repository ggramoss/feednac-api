package senac.feednac.application.converter;

import senac.feednac.application.dto.output.StudentDailyScheduleOutputDTO;
import senac.feednac.domain.StudentDailySchedule;

import java.util.List;
import java.util.Objects;

public class StudentDailyScheduleConverter {

    public static List<StudentDailyScheduleOutputDTO> toStudentDailyScheduleListOutputDTO(List<StudentDailySchedule> studentDailySchedules) {
        if (Objects.isNull(studentDailySchedules) || studentDailySchedules.isEmpty()) {
            return List.of();
        }

        return studentDailySchedules.stream().map(studentDailySchedule -> new StudentDailyScheduleOutputDTO(
                studentDailySchedule.getSemester(),
                DailyScheduleConverter.toDailyScheduleOutputDTO(studentDailySchedule.getDailySchedule())
        )).toList();
    }
}
