package lk.ijse.rent_a_car.business.custom;

import lk.ijse.rent_a_car.business.SuperBo;
import lk.ijse.rent_a_car.dto.LoginUserDto;

public interface LoginUserCustomBo extends SuperBo {
    public boolean searchUser(LoginUserDto loginUserDto) throws Exception;
}
