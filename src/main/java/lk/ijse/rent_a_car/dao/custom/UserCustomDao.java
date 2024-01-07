package lk.ijse.rent_a_car.dao.custom;

import lk.ijse.rent_a_car.dao.SuperDao;
import lk.ijse.rent_a_car.entity.NewUserEntity;

import java.sql.SQLException;

public interface UserCustomDao extends SuperDao {
    public boolean saveUser(NewUserEntity newUserEntity) throws Exception;
}
