package fan.company.springsecuritycompany.entity;

import fan.company.springsecuritycompany.entity.templates.AbsForIdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AttachmentContent extends AbsForIdEntity {

    private byte[] bytes;

    @OneToOne
    private Attachment attachment;

}
