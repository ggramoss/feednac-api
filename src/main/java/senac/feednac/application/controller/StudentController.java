package senac.feednac.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import senac.feednac.application.converter.StudentDailyScheduleConverter;
import senac.feednac.application.converter.StudentConverter;
import senac.feednac.application.response.ApiErrorResponse;
import senac.feednac.application.response.ApiResponse;
import senac.feednac.application.response.ApiSuccessResponse;
import senac.feednac.usecase.FindStudentDailyScheduleByStudentId;
import senac.feednac.usecase.StudentLoginUseCase;

import java.util.Objects;

@RestController
public class StudentController {

    private StudentLoginUseCase loginUseCase;
    private FindStudentDailyScheduleByStudentId findStudentDailyScheduleByStudentId;

    public StudentController(
            StudentLoginUseCase loginUseCase,
            FindStudentDailyScheduleByStudentId findStudentDailyScheduleByStudentId
    ) {
        this.loginUseCase = loginUseCase;
        this.findStudentDailyScheduleByStudentId = findStudentDailyScheduleByStudentId;
    }

    @GetMapping(path = "/login/student/{id}")
    @ResponseBody
    public ResponseEntity<ApiResponse> login(@PathVariable(name = "id") long id) {
        var student = loginUseCase.login(id);

        if (Objects.isNull(student)) {
            ApiErrorResponse apiResponse = new ApiErrorResponse(401);
            apiResponse.addErrorMessage("Aluno nåo existe");
            return ResponseEntity.status(401).body(apiResponse);
        }

        var outputDto = StudentConverter.toStudentOutputDTO(student);

        ApiSuccessResponse apiResponse = new ApiSuccessResponse(200, outputDto);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(path = "/student/{id}/dailySchedules")
    @ResponseBody
    public ResponseEntity<ApiResponse> getDailySchedulesById(@PathVariable(name = "id") long id) {
        var dailySchedules = findStudentDailyScheduleByStudentId.find(id);

        var outputDto = StudentDailyScheduleConverter.toStudentDailyScheduleListOutputDTO(dailySchedules);

        ApiSuccessResponse apiResponse = new ApiSuccessResponse(200, outputDto);
        return ResponseEntity.ok(apiResponse);
    }
}
