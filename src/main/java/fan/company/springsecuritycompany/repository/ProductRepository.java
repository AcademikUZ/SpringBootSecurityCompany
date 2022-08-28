package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findTopByOrderByIdDesc();

}
