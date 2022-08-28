package fan.company.springsecuritycompany.payload;

import lombok.Data;

import java.util.Date;


@Data

public class InputDto {

    private Date date;

    private Long warehouseId;

    private Long supplierId;

    private Long currencyId;

    private String factureNumber;

    private String code;


}
