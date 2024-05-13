package senac.feednac.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senac.feednac.application.converter.DailyScheduleConverter;
import senac.feednac.application.converter.TeacherConverter;
import senac.feednac.application.dto.TeacherLoginInputDTO;
import senac.feednac.application.response.ApiErrorResponse;
import senac.feednac.application.response.ApiResponse;
import senac.feednac.application.response.ApiSuccessResponse;
import senac.feednac.usecase.FindTeacherDailyScheduleByTeacherId;
import senac.feednac.usecase.TeacherLoginUseCase;

import java.util.ArrayList;
import java.util.Objects;

@RestController
public class TeacherController {

    private TeacherLoginUseCase teacherLogin;

    private FindTeacherDailyScheduleByTeacherId findTeacherDailyScheduleByTeacherId;

    public TeacherController(
            TeacherLoginUseCase teacherLogin,
            FindTeacherDailyScheduleByTeacherId findTeacherDailyScheduleByTeacherId
    ) {
        this.teacherLogin = teacherLogin;
        this.findTeacherDailyScheduleByTeacherId = findTeacherDailyScheduleByTeacherId;
    }

    @PostMapping(path = "/login/teacher")
    @ResponseBody
    public ResponseEntity<ApiResponse> login(@RequestBody TeacherLoginInputDTO login) {
        var teacher = teacherLogin.login(login);

        if (Objects.isNull(teacher)) {
            var messages = new ArrayList<String>();
            messages.add("Login ou senha inválidos");
            return ResponseEntity.status(401).body(new ApiErrorResponse(401, messages));
        }

        var dto = TeacherConverter.toTeacherLoginOutputDTO(teacher);

        return ResponseEntity.ok(new ApiSuccessResponse(200, dto));
    }

    @GetMapping(path = "/teacher/{id}/dailySchedules")
    @ResponseBody
    public ResponseEntity<ApiResponse> getDailySchedulesByTeacherId(@PathVariable(name = "id") Long id) {
        var dailySchedules = findTeacherDailyScheduleByTeacherId.find(id);

        var dto = DailyScheduleConverter.toDailySchedulesOutputDTO(dailySchedules);

        return ResponseEntity.ok(new ApiSuccessResponse(200, dto));
    }
}
