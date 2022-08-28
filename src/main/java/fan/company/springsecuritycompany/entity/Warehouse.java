package fan.company.springsecuritycompany.entity;

import fan.company.springsecuritycompany.entity.templates.AbsAllEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@Entity
public class Warehouse extends AbsAllEntity {
}
