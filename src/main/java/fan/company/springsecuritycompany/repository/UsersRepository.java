package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findTopByOrderByIdDesc();
}
