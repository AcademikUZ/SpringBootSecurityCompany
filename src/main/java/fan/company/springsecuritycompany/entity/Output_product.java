package fan.company.springsecuritycompany.entity;

import fan.company.springsecuritycompany.entity.templates.AbsForIdEntity;
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
public class Output_product extends AbsForIdEntity {

    @ManyToOne
    private Product product;

    private Double amount;

    private Double price;

    @ManyToOne
    private Output output;

}
