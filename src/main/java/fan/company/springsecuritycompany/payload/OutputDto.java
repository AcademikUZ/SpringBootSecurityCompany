package fan.company.springsecuritycompany.payload;


import lombok.Data;

import java.util.Date;

@Data

public class OutputDto {

    private Date date;

    private Long warehouseId;

    private Long clientId;

    private Long currencyId;

    private String factureNumber;

    private String code;


}
