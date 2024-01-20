package lk.ijse.rent_a_car.business.impl;

import lk.ijse.rent_a_car.business.custom.CarCategoryCustomBo;
import lk.ijse.rent_a_car.dao.DaoFactory;
import lk.ijse.rent_a_car.dao.DaoType;
import lk.ijse.rent_a_car.dao.custom.CarCategoryCustomDao;
import lk.ijse.rent_a_car.dto.CarCategoryDto;
import lk.ijse.rent_a_car.entity.CarCategoryEntity;

public class CarCategoryBoImpl implements CarCategoryCustomBo {

    @Override
    public boolean saveCarCategory(CarCategoryDto carCategoryDto) throws Exception{
        String id = carCategoryDto.getCarCategoryId();
        String name = carCategoryDto.getCarCategoryName();

        CarCategoryEntity car = new CarCategoryEntity(id, name);
        CarCategoryCustomDao category = DaoFactory.getDao(DaoType.CARCATEGORY);
        boolean isSaved = category.saveCarCategory(car);
        return isSaved;
    }
}
