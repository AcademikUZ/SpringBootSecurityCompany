package fan.company.springsecuritycompany.payload;

import lombok.Data;


@Data

public class CategoryDto{

    private Long parrentCategory;
    private String name;
    private boolean active = true;

}
