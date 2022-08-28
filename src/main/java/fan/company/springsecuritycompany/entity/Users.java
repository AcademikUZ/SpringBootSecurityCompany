package fan.company.springsecuritycompany.entity;

import fan.company.springsecuritycompany.entity.templates.AbsForIdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users extends AbsForIdEntity {

    private String firstName;
    private String lastName;
    private String code;
    @Column(unique = true)
    private String password;
    @Column(unique = true)
    private String phoneNumber;
    private boolean active;

    @ManyToMany
    Set<Warehouse> warehouses;


}
