package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Feedback;
import fan.company.springsecuritycompany.projection.CustomFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "feedback", collectionResourceRel = "list", excerptProjection = CustomFeedback.class)
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
