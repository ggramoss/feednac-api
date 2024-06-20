package senac.feednac.application.dto.output;

import java.util.List;

public record GetQuestionsOutputDTO(
        List<QuestionOutputDTO> questions
) {
}
