package lk.ijse.rent_a_car.dao.custom;

import lk.ijse.rent_a_car.dao.SuperDao;
import lk.ijse.rent_a_car.entity.LoginUserEntity;

import java.sql.SQLException;

public interface LoginUserCustomDao extends SuperDao {
    public boolean searcUser(LoginUserEntity loginUserEntity) throws SQLException;
}
