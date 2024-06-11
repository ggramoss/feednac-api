package senac.feednac.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senac.feednac.application.dto.CreateFeedbackInputDTO;
import senac.feednac.application.response.ApiSuccessResponse;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @PostMapping
    @ResponseBody
    public ResponseEntity<ApiSuccessResponse> create(@RequestBody CreateFeedbackInputDTO createFeedbackInputDTO) {
        return ResponseEntity.status(201).body(new ApiSuccessResponse(201, null));
    }
}
