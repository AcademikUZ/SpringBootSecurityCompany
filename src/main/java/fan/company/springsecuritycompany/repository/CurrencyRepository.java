package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Currency;
import fan.company.springsecuritycompany.projection.CustomCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "currency", collectionResourceRel = "list", excerptProjection = CustomCurrency.class)
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
