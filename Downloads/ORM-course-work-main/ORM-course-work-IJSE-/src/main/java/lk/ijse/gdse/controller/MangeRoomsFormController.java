package lk.ijse.gdse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gdse.dto.RoomsDTO;
import lk.ijse.gdse.entity.Rooms;
import lk.ijse.gdse.service.custom.impl.RooServiceImpl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MangeRoomsFormController implements Initializable {
    public TextField txtRoomId;
    public TextField txtType;
    public TextField txtKeyMoney;
    public TextField txtRoomQty;
    public TableColumn colRoomId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colRoomQty;
    public TableView<Rooms> tblRooms;

    RooServiceImpl  rooService = new RooServiceImpl();

    public void deleteStudentOnAction(ActionEvent actionEvent) {
    }

    public void updateStudentOnAction(ActionEvent actionEvent) {
    }

    public void saveBtnOnAction(ActionEvent actionEvent) {
        String roomId = txtRoomId.getText();
        String type = txtType.getText();
        String keyMoney = txtKeyMoney.getText();
        int roomQty = Integer.parseInt(txtRoomQty.getText());

        try {
            boolean save = rooService.save(new RoomsDTO(roomId,type,keyMoney,roomQty));
            if (save) {
                new Alert(Alert.AlertType.CONFIRMATION, "Rooms saved successful!").show();

            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Room can not saved").show();

            }

        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something happen please try again or contact developer").show();
        }

    }

    public void searchBtnOnAction(ActionEvent actionEvent) {
    }

    public void getAll(){

        ObservableList<Rooms> obList = FXCollections.observableArrayList();
        try {
            List<Rooms> roomsList = rooService.getAll();

            for (Rooms rooms:roomsList) {

                obList.add(new Rooms(
                        rooms.getRoom_type_id(),
                        rooms.getType(),
                        rooms.getKey_money(),
                        rooms.getQty()
                ));

            }
            tblRooms.setItems(obList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void setTableValue(){
        getAll();
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colRoomQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTableValue();
    }
}
