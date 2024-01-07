package lk.ijse.rent_a_car.business.impl;

import lk.ijse.rent_a_car.business.custom.UserCustomBo;
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

        String hashPassword = hashPasswordMD5(password);

        NewUserEntity newUserEntity = new NewUserEntity(name,nic, contact, address, userName,hashPassword);

        UserCustomDao userCustomDao = new NewUserDaoImpl();

        boolean isSaved = userCustomDao.saveUser(newUserEntity);

        return isSaved;
    }

    private static String hashPasswordMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedPasswordBytes = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedPasswordBytes) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
