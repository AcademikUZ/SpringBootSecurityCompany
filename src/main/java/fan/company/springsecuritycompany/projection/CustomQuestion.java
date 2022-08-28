package fan.company.springsecuritycompany.projection;

import fan.company.springsecuritycompany.entity.Questions;
import fan.company.springsecuritycompany.entity.Users;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Questions.class)
public interface CustomQuestion {

    public Long getId();

    public String getQuestion();

    public Users getUsers();

}
