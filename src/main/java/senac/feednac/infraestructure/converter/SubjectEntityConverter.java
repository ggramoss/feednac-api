package senac.feednac.infraestructure.converter;

import senac.feednac.domain.Subject;
import senac.feednac.infraestructure.entity.SubjectEntity;

public class SubjectEntityConverter {

    public static Subject toSubject(SubjectEntity entity) {
        return new Subject(
                entity.getId(),
                entity.getName()
        );
    }
}
