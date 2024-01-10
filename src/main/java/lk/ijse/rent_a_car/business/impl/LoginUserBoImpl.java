package lk.ijse.rent_a_car.business.impl;

import lk.ijse.rent_a_car.business.HashCodeGenarator;
import lk.ijse.rent_a_car.business.custom.LoginUserCustomBo;
import lk.ijse.rent_a_car.dao.DaoFactory;
import lk.ijse.rent_a_car.dao.DaoType;
import lk.ijse.rent_a_car.dao.custom.LoginUserCustomDao;
import lk.ijse.rent_a_car.dto.LoginUserDto;
import lk.ijse.rent_a_car.entity.LoginUserEntity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class LoginUserBoImpl implements LoginUserCustomBo {
    @Override
    public boolean searchUser(LoginUserDto loginUserDto) throws SQLException {
        String loginUsrName = loginUserDto.getLoginUserName();
        String loginPswrd = loginUserDto.getLoginPassword();

        String hashLoginPswrd = HashCodeGenarator.hashPasswordMD5(loginPswrd);

        LoginUserEntity loginUserEntity = new LoginUserEntity(loginUsrName, hashLoginPswrd);
        LoginUserCustomDao loginUserCustomDao = DaoFactory.getDao(DaoType.LOGINUSER);
        boolean isSearched = loginUserCustomDao.searcUser(loginUserEntity);


        return isSearched;
    }


}
