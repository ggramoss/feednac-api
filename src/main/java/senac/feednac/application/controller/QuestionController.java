package senac.feednac.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import senac.feednac.application.converter.QuestionConverter;
import senac.feednac.application.response.ApiSuccessResponse;
import senac.feednac.usecase.GetQuestionsUseCase;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private GetQuestionsUseCase getQuestionsUseCase;

    public QuestionController(GetQuestionsUseCase getQuestionsUseCase) {
        this.getQuestionsUseCase = getQuestionsUseCase;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<ApiSuccessResponse> getQuestions() {
        var dto = QuestionConverter.toQuestionList(getQuestionsUseCase.get());
        return ResponseEntity.status(200).body(new ApiSuccessResponse(200, dto));
    }
}
