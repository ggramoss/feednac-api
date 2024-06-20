package senac.feednac.application.dto.output;

import java.util.List;

public record QuestionOutputDTO(
        Long id, String answer, List<AnswerOptionOutputDTO> options
) {
}
