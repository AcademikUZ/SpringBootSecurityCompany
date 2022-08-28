package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
