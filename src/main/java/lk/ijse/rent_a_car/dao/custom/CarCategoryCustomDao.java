package lk.ijse.rent_a_car.dao.custom;

import lk.ijse.rent_a_car.dao.SuperDao;
import lk.ijse.rent_a_car.entity.CarCategoryEntity;

public interface CarCategoryCustomDao extends SuperDao {
    public boolean saveCarCategory(CarCategoryEntity carCategoryEntity) throws Exception;
}
