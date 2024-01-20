package lk.ijse.rent_a_car.dao.impl;

import lk.ijse.rent_a_car.dao.custom.CarCategoryCustomDao;
import lk.ijse.rent_a_car.db.DbConnection;
import lk.ijse.rent_a_car.entity.CarCategoryEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CarCategoryDaoImpl implements CarCategoryCustomDao {
    @Override
    public boolean saveCarCategory(CarCategoryEntity carCategoryEntity) throws Exception {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO car_category VALUES(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,carCategoryEntity.getId());
        statement.setString(2,carCategoryEntity.getName());

        int affectedRows = statement.executeUpdate();
        return (affectedRows>0);
    }
}
