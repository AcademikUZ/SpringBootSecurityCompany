package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
