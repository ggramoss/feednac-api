package senac.feednac.application.dto.input;

import java.util.List;

public record CreateFeedbackInputDTO (
         Long studentId,
         Long courseSessionId,
         Long generalNote,
         String additionalComment,
         List<QuestionAnswered> questionsAnswered
) {}
