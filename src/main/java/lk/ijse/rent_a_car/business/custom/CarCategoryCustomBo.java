package lk.ijse.rent_a_car.business.custom;

import lk.ijse.rent_a_car.business.SuperBo;
import lk.ijse.rent_a_car.dto.CarCategoryDto;

public interface CarCategoryCustomBo extends SuperBo {
    public boolean saveCarCategory(CarCategoryDto carCategoryDto) throws Exception;
}
