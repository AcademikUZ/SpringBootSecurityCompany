package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Output;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputRepository extends JpaRepository<Output, Long> {
    Output findTopByOrderByIdDesc();
}
