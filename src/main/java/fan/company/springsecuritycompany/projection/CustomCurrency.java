package fan.company.springsecuritycompany.projection;

import fan.company.springsecuritycompany.entity.Currency;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Currency.class)
public interface CustomCurrency {

    public Long getId();

    public String getName();

    public boolean isActive();

    public double getSumNow();

    public double getRublNow();

    public double getDollarNow();

}
