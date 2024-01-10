package lk.ijse.rent_a_car.dao.impl;

import javafx.scene.control.Alert;
import lk.ijse.rent_a_car.dao.custom.LoginUserCustomDao;
import lk.ijse.rent_a_car.db.DbConnection;
import lk.ijse.rent_a_car.entity.LoginUserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUserDaoImpl implements LoginUserCustomDao {
    @Override
    public boolean searcUser(LoginUserEntity loginUserEntity) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,loginUserEntity.getUserName());
        ResultSet rslt = statement.executeQuery();
        if(rslt.next()){
            String name = rslt.getString("password");
            if(loginUserEntity.getPassword().equals(name)){
                return true;
            }else {
                new Alert(Alert.AlertType.ERROR,"Your password is incorrect. Please retry.").show();
                return false;
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Your user name is incorrect. Please retry.").show();
            return false;
        }

    }
}
