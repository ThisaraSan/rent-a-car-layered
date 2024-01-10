package lk.ijse.rent_a_car.business;

import lk.ijse.rent_a_car.business.impl.LoginUserBoImpl;
import lk.ijse.rent_a_car.business.impl.NewUserBoImpl;

public class BoFactory {
    public static <T extends SuperBo>T getBo(BoType type){
        switch (type){
            case NEWUSER:
                return (T) new NewUserBoImpl();
            case LOGINUSER:
                return (T) new LoginUserBoImpl();
            default:
                return null;
        }
    }
}
