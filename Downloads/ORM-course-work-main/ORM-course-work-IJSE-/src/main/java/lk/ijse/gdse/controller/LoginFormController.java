package lk.ijse.gdse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.gdse.dto.UserDTO;
import lk.ijse.gdse.service.custom.impl.UserServiceImpl;
import lk.ijse.gdse.util.Navigation;
import lk.ijse.gdse.util.Routes;


public class LoginFormController {
    public TextField txtUserName;
    public PasswordField txtPassword;
    public AnchorPane signUpContext;
    public TextField signupFullName;
    public TextField signUpUserName;
    public TextField singUpPassword;
    public TextField signUpEmail;
    public AnchorPane mainContext;
    public CheckBox checkBoxShowPassword;
    public TextField showPasswordField;


    UserServiceImpl userService = new UserServiceImpl();


    public void clearField() {
        signupFullName.clear();
        signUpUserName.clear();
        signUpEmail.clear();
        singUpPassword.clear();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
        String userName = txtUserName.getText();

        try {

            if (txtPassword.getText().isEmpty() && txtUserName.getText().isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Enter username and password").show();
            } else if (txtPassword.getText().isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Enter password").show();
            } else if (txtUserName.getText().isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Enter username").show();
            } else {
                UserDTO userDTO = userService.search(userName);
                String userName1 = userDTO.getUserName();
                String password = userDTO.getPassword();


                if ((txtUserName.getText().equals(userName1) && txtPassword.getText().equals(password))) {
                    Stage stage = Navigation.init(mainContext);
                    stage.close();
                    Navigation.navigate(Routes.DashBoard,mainContext);
                } else {
                    new Alert(Alert.AlertType.ERROR, "something happen, please try again").show();

                }
            }

        } catch (NullPointerException e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Enter valid user name and password").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something happen please try again or contact developer").show();
            throw new RuntimeException(e);
        }

    }

    public void btnSignUpOnAction(ActionEvent actionEvent) {
        signUpContext.setVisible(true);
    }

    public void btnLoginSignupFormOnAction(ActionEvent actionEvent) {
        signUpContext.setVisible(false);
    }

    public void btnSignupInSignFormOnAction(ActionEvent actionEvent) {
        String name = signupFullName.getText();
        String userName = signUpUserName.getText();
        String email = signUpEmail.getText();
        String password = singUpPassword.getText();

        try {
            if (userService.save(new UserDTO(name, userName, email, password))) {
                new Alert(Alert.AlertType.CONFIRMATION, "User saved successful!").show();
                clearField();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.WARNING, "Can not save user please try again..").show();
        }

    }

    public void checkBoxShowPassword(ActionEvent actionEvent) {
        boolean selected = checkBoxShowPassword.isSelected();
        if (selected) {
            txtPassword.setVisible(false);
            showPasswordField.setVisible(true);
            showPasswordField.setText(txtPassword.getText());
        } else {
            txtPassword.setVisible(true);
            showPasswordField.setVisible(false);
        }

    }


}

