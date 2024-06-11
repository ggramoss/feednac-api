package senac.feednac.infraestructure.converter;

import senac.feednac.domain.AnswerOption;
import senac.feednac.infraestructure.entity.AnswerOptionEntity;

import java.util.List;

public class AnswerOptionEntityConverter {

    public static List<AnswerOption> toAnswerOptions(List<AnswerOptionEntity> entityList) {
        return entityList.stream().map(entity -> new AnswerOption(
                entity.getId(),
                entity.getOption()
        )).toList();
    }
}
