package lk.ijse.rent_a_car.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewUserEntity {
    private String name;
    private String nic;
    private String contact;
    private String address;
    private String userName;
    private String hashPassword;

}
