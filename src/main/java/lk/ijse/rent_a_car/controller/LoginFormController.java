package lk.ijse.rent_a_car.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.rent_a_car.business.BoFactory;
import lk.ijse.rent_a_car.business.BoType;
import lk.ijse.rent_a_car.business.custom.LoginUserCustomBo;
import lk.ijse.rent_a_car.dto.LoginUserDto;

import java.io.IOException;

public class LoginFormController {
    @FXML
    private ImageView imageView;
    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    public void createAccountMouseClick(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/user_registration_form.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("User Registration Form");
        stage.show();

    }

    public void btnLoginAction(ActionEvent actionEvent){
        String loginUserName = txtUserName.getText();
        String loginPassword = txtPassword.getText();

        LoginUserDto loginUserDto = new LoginUserDto(loginUserName,loginPassword);
        LoginUserCustomBo loginUserCustomBo = BoFactory.getBo(BoType.LOGINUSER);

        try {
            boolean isSearched = loginUserCustomBo.searchUser(loginUserDto);

            if(isSearched){
                Parent root = FXMLLoader.load(this.getClass().getResource("/view/dashboard_page.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Main Menu");
                stage.show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }
}
