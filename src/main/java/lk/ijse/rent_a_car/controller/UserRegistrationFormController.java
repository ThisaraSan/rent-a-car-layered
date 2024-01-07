package lk.ijse.rent_a_car.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import lk.ijse.rent_a_car.business.BoFactory;
import lk.ijse.rent_a_car.business.BoType;
import lk.ijse.rent_a_car.business.custom.UserCustomBo;
import lk.ijse.rent_a_car.business.impl.NewUserBoImpl;
import lk.ijse.rent_a_car.dto.NewUserDto;


public class UserRegistrationFormController {
    @FXML
    private AnchorPane basePane;
    Stage stage;
    @FXML
    private Button exitButton;
    @FXML
    private ImageView image;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtContactNo;
    @FXML
    private TextField txtCreatePassword;
    @FXML
    private TextField txtCreateUserName;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtNic;

    public void btnExitAction(ActionEvent actionEvent) {
        stage = (Stage)basePane.getScene().getWindow();
        stage.close();
    }

    public void clear(){

    }

    public void btnSaveAction(ActionEvent actionEvent){
        String name = txtName.getText();
        String nic = txtNic.getText();
        String contact = txtContactNo.getText();
        String address = txtAddress.getText();
        String userName = txtCreateUserName.getText();
        String password = txtCreatePassword.getText();

        NewUserDto newUserDto = new NewUserDto(name,nic,contact,address,userName,password);

        UserCustomBo newUser = BoFactory.getBo(BoType.NEWUSER);
        try {
            boolean isSaved = newUser.saveUser(newUserDto);
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"User Created Successfully").show();
                clearText();

            }
        } catch (Exception e) {
            String eror= e.getMessage();
            editError("USER CTEATION FAILED!", "Please retry with changing following.",eror);
        }

    }
    public void editError(String title, String content, String error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(content);
        alert.setContentText(error);
        alert.showAndWait();
    }

    private void clearText(){
        txtName.clear();
        txtNic.clear();
        txtContactNo.clear();
        txtAddress.clear();
        txtCreateUserName.clear();
        txtCreatePassword.clear();
    }
}
