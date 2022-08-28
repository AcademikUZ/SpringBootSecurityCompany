package fan.company.springsecuritycompany.payload;


import lombok.Data;



@Data

public class Output_productDto {

    private Long productId;

    private Double amount;

    private Double price;

    private Long outputId;

}
