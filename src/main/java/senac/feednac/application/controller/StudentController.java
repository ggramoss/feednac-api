package senac.feednac.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import senac.feednac.application.converter.CalendarConverter;
import senac.feednac.application.converter.StudentConverter;
import senac.feednac.application.response.ApiErrorResponse;
import senac.feednac.application.response.ApiResponse;
import senac.feednac.application.response.ApiSuccessResponse;
import senac.feednac.usecase.FindCalendarByStudentId;
import senac.feednac.usecase.StudentLoginUseCase;

import java.util.Objects;

@RestController
public class StudentController {

    private StudentLoginUseCase loginUseCase;
    private FindCalendarByStudentId findCalendarByStudentId;

    public StudentController(
            StudentLoginUseCase loginUseCase,
            FindCalendarByStudentId findCalendarByStudentId
    ) {
        this.loginUseCase = loginUseCase;
        this.findCalendarByStudentId = findCalendarByStudentId;
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

    @GetMapping(path = "/student/{id}/calendar")
    @ResponseBody
    public ResponseEntity<ApiResponse> getCalendarById(@PathVariable(name = "id") long id) {
        var calendar = findCalendarByStudentId.find(id);

        var outputDto = CalendarConverter.calendarOutputDTO(calendar);

        ApiSuccessResponse apiResponse = new ApiSuccessResponse(200, outputDto);
        return ResponseEntity.ok(apiResponse);
    }
}
