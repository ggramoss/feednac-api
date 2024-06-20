package senac.feednac.infraestructure.repository;

import org.springframework.stereotype.Service;
import senac.feednac.domain.AnswerOption;
import senac.feednac.infraestructure.converter.AnswerOptionEntityConverter;

@Service
public class AnswerOptionRepository {

    private AnswerOptionJPARepository jpaRepository;

    public AnswerOptionRepository(AnswerOptionJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public AnswerOption findById(Long id) {
        var answerOptionEntity = this.jpaRepository.findById(id);
        return answerOptionEntity.map(AnswerOptionEntityConverter::toAnswerOption).orElse(null) ;
    }
}
