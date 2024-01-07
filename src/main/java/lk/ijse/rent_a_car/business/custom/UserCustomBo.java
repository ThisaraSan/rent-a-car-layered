package lk.ijse.rent_a_car.business.custom;

import lk.ijse.rent_a_car.business.SuperBo;
import lk.ijse.rent_a_car.dto.NewUserDto;

public interface UserCustomBo extends SuperBo {
    public boolean saveUser(NewUserDto newUserDto) throws Exception;
}
