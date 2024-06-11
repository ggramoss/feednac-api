package senac.feednac.application.dto;

import java.util.List;

public record GetQuestionsOutputDTO(
        List<QuestionOutputDTO> questions
) {
}
