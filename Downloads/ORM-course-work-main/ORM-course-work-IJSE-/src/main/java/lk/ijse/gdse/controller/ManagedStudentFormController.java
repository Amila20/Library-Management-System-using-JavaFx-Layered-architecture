package lk.ijse.gdse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gdse.dto.StudentDTO;
import lk.ijse.gdse.entity.Student;
import lk.ijse.gdse.service.custom.impl.StudentServiceImpl;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ManagedStudentFormController implements Initializable {

    public TextField txtStudentId;
    public TextField txtStudentName;
    public TextField txtAddress;
    public TextField txtContactNo;
    public RadioButton radioBtnMale;
    public ToggleGroup radioBtnGender;
    public RadioButton radioBtnFemale;
    public DatePicker dateDOB;
    public TextField txtSearch;
    public TableView <Student> tblStudent;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colGender;
    public TableColumn colDob;

    StudentServiceImpl studentService = new StudentServiceImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setTableValue();

    }

    public void saveBtnOnAction(ActionEvent actionEvent) {

        String gender;
        if (radioBtnFemale.isSelected()) {
            gender = "FeMale";
        } else {
            gender = "Male";
        }

        String studentId = txtStudentId.getText();
        String name = txtStudentName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        Date date = Date.valueOf(dateDOB.getValue());

        try {
            boolean save = studentService.save(new StudentDTO(studentId, name, address, contactNo, date, gender));
            if (save) {
                new Alert(Alert.AlertType.CONFIRMATION, "User saved successful!").show();

            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "User can not saved").show();

            }

            tblStudent.refresh();

        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something happen please try again or contact developer").show();
        }

        setTableValue();

    }

    public void updateStudentOnAction(ActionEvent actionEvent) {
        String gender;
        if (radioBtnFemale.isSelected()) {
            gender = "FeMale";
        } else {
            gender = "Male";
        }

        String studentId = txtStudentId.getText();
        String name = txtStudentName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        Date date = Date.valueOf(dateDOB.getValue());

        try {
            boolean student = studentService.update(new StudentDTO(studentId, name, address, contactNo, date, gender));
            if (student) {
                new Alert(Alert.AlertType.CONFIRMATION, "User Update successful!").show();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "User can not update").show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something happen please try again or contact developer").show();
        }
    }

    public void deleteStudentOnAction(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.WARNING, "do you want delete Student");
        alert.show();

        try {
            boolean delete = studentService.delete(txtStudentId.getText());
            if (delete) {
                new Alert(Alert.AlertType.CONFIRMATION, "Student delete successful!").show();
            } else {

                new Alert(Alert.AlertType.CONFIRMATION, "User can not delete").show();
            }
        } catch (Exception e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Something happen please try again or contact developer").show();
        }

        setTableValue();

    }

    public void searchBtnOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO = studentService.search(txtSearch.getText());
        String studentId = studentDTO.getStudent_id();
        String name = studentDTO.getName();
        String address = studentDTO.getAddress();
        String contactNo = studentDTO.getContact_no();
        String gender = studentDTO.getGender();


        txtStudentId.setText(studentId);
        txtStudentName.setText(name);
        txtAddress.setText(address);
        txtContactNo.setText(contactNo);


        if (Objects.equals(gender, "Male")) {
            radioBtnMale.setSelected(true);
        } else if (Objects.equals(gender, "FeMale")) {
            radioBtnFemale.setSelected(true);
        }
    }


    public void getAll(){

        ObservableList<Student> obList = FXCollections.observableArrayList();
        try {
            List<Student> studentList = studentService.getAll();

            for (Student student:studentList) {

                obList.add(new Student(
                        student.getStudent_id(),
                        student.getName(),
                        student.getAddress(),
                        student.getContact_no(),
                        student.getDob(),
                        student.getGender()
                        ));

            }
            tblStudent.setItems(obList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void setTableValue(){
        getAll();
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

    }

}
