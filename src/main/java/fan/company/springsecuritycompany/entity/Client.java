package fan.company.springsecuritycompany.entity;

import fan.company.springsecuritycompany.entity.templates.AbsAllEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Client extends AbsAllEntity {
    @Column(unique = true)
    private String phoneNumber;
}
