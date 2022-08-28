package fan.company.springsecuritycompany.payload;


import lombok.Data;

@Data
public class SupplierDto {

    private String phoneNumber;
    private String name;
    private boolean active = true;


}
