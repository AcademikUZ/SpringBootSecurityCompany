package fan.company.springsecuritycompany.entity;

import fan.company.springsecuritycompany.entity.templates.AbsAllEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Category extends AbsAllEntity {

    @ManyToOne
    private Category parrentCategory;

}
