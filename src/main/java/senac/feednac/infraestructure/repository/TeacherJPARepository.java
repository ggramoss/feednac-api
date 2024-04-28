package senac.feednac.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senac.feednac.infraestructure.entity.TeacherEntity;

import java.util.Optional;

@Repository
public interface TeacherJPARepository extends JpaRepository<TeacherEntity, Long> {

    Optional<TeacherEntity> findIdByUsernameAndPassword(String username, String password);
}

