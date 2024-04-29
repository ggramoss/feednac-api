package senac.feednac.infraestructure.converter;

import senac.feednac.domain.Subject;
import senac.feednac.domain.Teacher;
import senac.feednac.infraestructure.entity.TeacherEntity;

import java.util.ArrayList;

public class TeacherEntityConverter {

    public static Teacher toTeacher(TeacherEntity entity) {
        var subjects = new ArrayList<Subject>();

        entity.getSubject().forEach(subjectEntity -> {
         var subject = new Subject(
                 subjectEntity.getId(),
                 subjectEntity.getName()
         );

         subjects.add(subject);
        });

        return new Teacher(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getTelephone(),
                subjects
        );
    }
}
