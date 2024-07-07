package lk.ijse.gdse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import lk.ijse.gdse.util.Navigation;
import lk.ijse.gdse.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable {

    public AnchorPane dashBoardContext;
    public Button btnManageStudent;
    public Button btnManageRooms;
    public Button btnReservation;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            dashBoardContext.getChildren().clear();
            URL resource = Navigation.class.getResource("/view/ManagedStudentForm.fxml");
            Parent load = FXMLLoader.load(resource);
            dashBoardContext.getChildren().add(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnManageStudentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ManageStudent,dashBoardContext);

    }

    public void btnReservationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ReservationForm,dashBoardContext);
    }

    public void btnManageRoomsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ManageRooms,dashBoardContext);

    }
}
