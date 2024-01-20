package lk.ijse.rent_a_car.dao;

import lk.ijse.rent_a_car.dao.impl.CarCategoryDaoImpl;
import lk.ijse.rent_a_car.dao.impl.LoginUserDaoImpl;
import lk.ijse.rent_a_car.dao.impl.NewUserDaoImpl;

public class DaoFactory {
    public static <T extends SuperDao>T getDao(DaoType type){
        switch (type){
            case NEWUSER:
                return (T) new NewUserDaoImpl();
            case LOGINUSER:
                return (T) new LoginUserDaoImpl();
            case CARCATEGORY:
                return (T) new CarCategoryDaoImpl();
            default:
                return null;
        }
    }
}
