package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<Input, Long> {
   Input findTopByOrderByIdDesc();
}
