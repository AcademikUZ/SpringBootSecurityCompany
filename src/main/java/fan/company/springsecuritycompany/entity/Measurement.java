package fan.company.springsecuritycompany.entity;

import fan.company.springsecuritycompany.entity.templates.AbsAllEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Measurement extends AbsAllEntity {

    public Measurement() {
    }
}
