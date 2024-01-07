package lk.ijse.rent_a_car.dao.impl;

import lk.ijse.rent_a_car.dao.custom.UserCustomDao;
import lk.ijse.rent_a_car.db.DbConnection;
import lk.ijse.rent_a_car.entity.NewUserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewUserDaoImpl implements UserCustomDao {
    @Override
    public boolean saveUser(NewUserEntity entity) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO user VALUES(?,?,?,?,?,?)";
        PreparedStatement pstmn = connection.prepareStatement(sql);
        pstmn.setString(1,entity.getName());
        pstmn.setString(2,entity.getNic());
        pstmn.setString(3, entity.getContact());
        pstmn.setString(4, entity.getAddress());
        pstmn.setString(5, entity.getUserName());
        pstmn.setString(6, entity.getHashPassword());

        int affectedRows = pstmn.executeUpdate();
        return (affectedRows>0);
    }
}
