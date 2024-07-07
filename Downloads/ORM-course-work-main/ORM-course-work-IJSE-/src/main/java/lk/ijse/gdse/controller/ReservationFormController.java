package lk.ijse.gdse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.entity.Rooms;
import lk.ijse.gdse.service.custom.impl.ReservationServiceImpl;
import lk.ijse.gdse.service.custom.impl.RooServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ReservationFormController {
    public AnchorPane dashBoardContext;

    public TextField txtReservationId;
    public TextField txtStudentId;
    public TextField txtRoomId;
    public TextField txtKeyMoney;
    public TextField txtStudentName;
    public Button btnAddCart;
    public Button btnReserVation;
    public Label checkBoxPaid;
    public ComboBox cmbRoomsId;
    public TextField txtQty;
    RooServiceImpl rooService=new RooServiceImpl();

    public void initialize(){
        SetRoomsId();

    }
    public void btnAddCartOnAction(ActionEvent actionEvent) {
    }

    public void btnReservationOnAction(ActionEvent actionEvent) {
    }
    public void SetRoomsId(){

          List<Rooms>idList=rooService.getAllIds();
         cmbRoomsId.setValue(idList);
        }





        }




