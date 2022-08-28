package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WareHouseRepository extends JpaRepository<Warehouse, Long> {
}
