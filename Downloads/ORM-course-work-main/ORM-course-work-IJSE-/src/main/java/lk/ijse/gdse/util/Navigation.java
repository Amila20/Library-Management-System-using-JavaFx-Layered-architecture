package lk.ijse.gdse.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class Navigation {

    private AnchorPane anchorPaneContext;

    public static Stage init(AnchorPane anchorPane) throws IOException {
        return (Stage)anchorPane.getScene().getWindow();
    }

    public static void navigate(Routes routes,AnchorPane anchorPaneContext)throws IOException {

//        Stage stage = new Stage();
        Stage stage = init(anchorPaneContext);
        anchorPaneContext.getChildren().clear();

        URL resource = null;

        switch (routes){
            case DashBoard:
                 resource = Navigation.class.getResource("/view/DashBoardForm.fxml");
                 break;

            case ManageStudent:
                resource = Navigation.class.getResource("/view/ManagedStudentForm.fxml");
                Parent load = FXMLLoader.load(resource);
                anchorPaneContext.getChildren().add(load);
                stage.setTitle("Manage student");
                return;

            case ManageRooms:
                resource = Navigation.class.getResource("/view/MangeRoomsForm.fxml");
                Parent load1 = FXMLLoader.load(resource);
                anchorPaneContext.getChildren().add(load1);
                stage.setTitle("Manage Rooms");
                return;

                case ReservationForm:
                    resource = Navigation.class.getResource("/view/ReservationForm.fxml");
                    Parent load2 = FXMLLoader.load(resource);
                    anchorPaneContext.getChildren().add(load2);
                    stage.setTitle("Reservation Form");
                    return;


        }

        Parent load = FXMLLoader.load(resource);
        stage.setScene(new Scene(load));
        stage.show();



    }

}
