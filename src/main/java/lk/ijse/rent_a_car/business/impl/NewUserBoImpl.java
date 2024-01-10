package lk.ijse.rent_a_car.business.impl;

import lk.ijse.rent_a_car.business.HashCodeGenarator;
import lk.ijse.rent_a_car.business.custom.UserCustomBo;
import lk.ijse.rent_a_car.dao.DaoFactory;
import lk.ijse.rent_a_car.dao.DaoType;
import lk.ijse.rent_a_car.dao.custom.UserCustomDao;
import lk.ijse.rent_a_car.dao.impl.NewUserDaoImpl;
import lk.ijse.rent_a_car.dto.NewUserDto;
import lk.ijse.rent_a_car.entity.NewUserEntity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NewUserBoImpl implements UserCustomBo {
    @Override
    public boolean saveUser(NewUserDto newUserDto) throws Exception {
        String name = newUserDto.getName();
        String nic = newUserDto.getNic();
        String contact = newUserDto.getContact();
        String address = newUserDto.getAddress();
        String userName = newUserDto.getUserName();
        String password = newUserDto.getPassword();

        String hashPassword = HashCodeGenarator.hashPasswordMD5(password);

        NewUserEntity newUserEntity = new NewUserEntity(name,nic, contact, address, userName,hashPassword);

        UserCustomDao userCustomDao = DaoFactory.getDao(DaoType.NEWUSER);

        boolean isSaved = userCustomDao.saveUser(newUserEntity);

        return isSaved;
    }


}
