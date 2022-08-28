package fan.company.springsecuritycompany.projection;

import fan.company.springsecuritycompany.entity.Feedback;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Feedback.class)
public interface CustomFeedback {

    public Long getId();

    public String getAuthorName();

    public String getFeedback();

}
