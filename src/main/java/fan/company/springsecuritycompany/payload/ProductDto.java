package fan.company.springsecuritycompany.payload;


import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class ProductDto {

    @NotNull
    private Long categoryId;
    private String code;
    @NotNull
    private Long photoId;
    @NotNull
    private Long measurementId;
    @NotNull
    private String name;
    @NotNull
    private boolean active = true;


}
