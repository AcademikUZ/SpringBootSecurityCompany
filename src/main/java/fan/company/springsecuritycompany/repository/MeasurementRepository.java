package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

}
