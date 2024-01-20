package lk.ijse.rent_a_car.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import lk.ijse.rent_a_car.business.BoFactory;
import lk.ijse.rent_a_car.business.BoType;
import lk.ijse.rent_a_car.business.custom.CarCategoryCustomBo;
import lk.ijse.rent_a_car.dto.CarCategoryDto;

public class DashboardPageController {
    @FXML
    private AnchorPane carCategoryPane;

    @FXML
    private AnchorPane stagePane;

    @FXML
    private TextField txtCarCategoryId;

    @FXML
    private TextField txtCarCategoryName;
    public void btnCarCategoryAction(ActionEvent actionEvent) {
        stagePane.getChildren().clear();
        stagePane.getChildren().add(carCategoryPane);
        //carCategoryPane.setVisible(true);
    }

    public void btnAddCategoryAction(ActionEvent actionEvent) {
        String id = txtCarCategoryId.getText();
        String name = txtCarCategoryName.getText();

        CarCategoryDto car = new CarCategoryDto(id,name);
        CarCategoryCustomBo category = BoFactory.getBo(BoType.CARCATEGORY);
        try {
            boolean isSaved = category.saveCarCategory(car);
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Car Category Added Successfully").show();
                txtCarCategoryId.setText("");
                txtCarCategoryName.setText("");
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
}
