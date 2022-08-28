package fan.company.springsecuritycompany.repository;


import fan.company.springsecuritycompany.entity.B2BClient;
import fan.company.springsecuritycompany.projection.CustomB2BClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "B2BClient", collectionResourceRel = "list", excerptProjection = CustomB2BClient.class)
public interface B2BClientRepository extends JpaRepository<B2BClient, Long> {
}
