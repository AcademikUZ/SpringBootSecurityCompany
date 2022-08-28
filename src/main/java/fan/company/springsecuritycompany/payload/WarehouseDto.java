package fan.company.springsecuritycompany.payload;

import lombok.Data;

@Data
public class WarehouseDto {

    private String name;

    private boolean active = true;
}
