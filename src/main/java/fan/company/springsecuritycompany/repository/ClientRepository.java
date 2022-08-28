package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
