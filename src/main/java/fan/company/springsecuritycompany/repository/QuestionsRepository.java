package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Questions;
import fan.company.springsecuritycompany.projection.CustomQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "questions", collectionResourceRel = "list", excerptProjection = CustomQuestion.class)
public interface QuestionsRepository extends JpaRepository<Questions, Long> {
}
