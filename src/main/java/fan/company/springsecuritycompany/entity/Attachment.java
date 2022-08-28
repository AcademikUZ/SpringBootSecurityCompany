package fan.company.springsecuritycompany.entity;

import fan.company.springsecuritycompany.entity.templates.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Attachment extends AbsEntity {

    private long size;
    private String contentType;
    private String originalName;

}
