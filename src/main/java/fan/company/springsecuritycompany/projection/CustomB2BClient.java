package fan.company.springsecuritycompany.projection;

import fan.company.springsecuritycompany.entity.B2BClient;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = B2BClient.class)
public interface CustomB2BClient {

    public Long getId();

    public String getName();

    public String getPhoneNumber();

    public boolean isActive();

    public String getEmail();

    public String getSms();


}
