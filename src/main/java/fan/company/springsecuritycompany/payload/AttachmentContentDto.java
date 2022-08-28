package fan.company.springsecuritycompany.payload;

import fan.company.springsecuritycompany.entity.templates.AbsForIdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data

public class AttachmentContentDto extends AbsForIdEntity {

    private byte[] bytes;
    private Long attachmentId;

}
