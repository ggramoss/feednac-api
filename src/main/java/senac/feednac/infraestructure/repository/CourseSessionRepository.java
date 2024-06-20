package senac.feednac.infraestructure.repository;

import org.springframework.stereotype.Service;
import senac.feednac.domain.CourseSession;
import senac.feednac.infraestructure.converter.CourseSessionEntityConverter;

@Service
public class CourseSessionRepository {

    private CourseSessionJPARepository jpaRepository;

    public CourseSessionRepository(CourseSessionJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public CourseSession findById(Long id) {
        var courseSessionEntity = this.jpaRepository.findById(id);
        System.out.println("find by id course session repository");
        return courseSessionEntity.map(CourseSessionEntityConverter::toCourseSession).orElse(null);
    }
}
