package lk.ijse.rent_a_car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewUserDto {
    private String name;
    private String nic;
    private String contact;
    private String address;
    private String userName;
    private String password;

}
