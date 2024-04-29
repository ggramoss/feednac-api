package senac.feednac.infraestructure.converter;

import senac.feednac.domain.Class;
import senac.feednac.infraestructure.entity.ClassEntity;

public class ClassEntityConverter {

    public static Class toClass(ClassEntity entity) {
        return new Class(
                entity.getId(),
                entity.getName()
        );
    }
}
