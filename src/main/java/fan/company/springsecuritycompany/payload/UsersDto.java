package fan.company.springsecuritycompany.payload;


import lombok.Data;

@Data

public class UsersDto {

    private String firstName;
    private String lastName;
    private String code;
    private String password;
    private String phoneNumber;
    private boolean active;
    private Long warehousesId;


}
