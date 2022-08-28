package fan.company.springsecuritycompany.repository;

import fan.company.springsecuritycompany.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
