package senac.feednac.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senac.feednac.application.converter.FeedbackConverter;
import senac.feednac.application.dto.input.CreateFeedbackInputDTO;
import senac.feednac.application.response.ApiSuccessResponse;
import senac.feednac.usecase.CreateFeedbackUseCase;
import senac.feednac.usecase.GetFeedbacksUseCase;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private CreateFeedbackUseCase createFeedbackUseCase;

    private GetFeedbacksUseCase getFeedbacksUseCase;

    public FeedbackController(
            CreateFeedbackUseCase createFeedbackUseCase,
            GetFeedbacksUseCase getFeedbacksUseCase
    ) {
        this.createFeedbackUseCase = createFeedbackUseCase;
        this.getFeedbacksUseCase = getFeedbacksUseCase;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ApiSuccessResponse> create(@RequestBody CreateFeedbackInputDTO createFeedbackInputDTO) {
        createFeedbackUseCase.create(createFeedbackInputDTO);
        return ResponseEntity.status(201).body(new ApiSuccessResponse(201, "ok"));
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<ApiSuccessResponse> getByTeacherIdAndCourseSessionId(
            @RequestParam(name = "teacherId") Long teacherId,
            @RequestParam(name = "courseSessionId") Long courseSessionId
    ) {
        var answers = this.getFeedbacksUseCase.getByTeacherIdAndCourseSessionId(teacherId, courseSessionId);
        var dto = FeedbackConverter.toGetFeedbackOutputDTO(answers);
        return ResponseEntity.status(201).body(new ApiSuccessResponse(200, dto));
    }
}
