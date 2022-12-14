package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Technical–°haracteristics;
import fan.company.springsecuritycompany.projection.CustomTechnicalCharacteristics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "technicalcharacteristics", collectionResourceRel = "list", excerptProjection = CustomTechnicalCharacteristics.class)
public interface TechnicalCharacteristicsRepository extends JpaRepository<Technical–°haracteristics, Long> {
}
