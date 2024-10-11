package com.finalproj.Controller;

import com.finalproj.Modal.Address;
import com.finalproj.Modal.Hospital;
import com.finalproj.Modal.Patient;
import com.finalproj.Modal.TreatmentRoom;
import com.finalproj.Utils.BackToHome;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TreatmentRoomViewController extends HospitalController implements Initializable {
    @FXML
    private Button backHomeBtn;
    @FXML
    private TableView<TreatmentRoom> tableViewRoom;
    @FXML
    private TableColumn<TreatmentRoom, Integer> colIdRoom;
    @FXML
    private TableColumn<TreatmentRoom, String> colNameRoom;
    @FXML
    private TableColumn<TreatmentRoom, String> colTypeRoom;
    @FXML
    private TableColumn<TreatmentRoom, Integer> colCapacity;

    @FXML
    private TableView<Patient> infoPatient;
    @FXML
    private TableColumn<Patient, Integer> idCol;
    @FXML
    private TableColumn<Patient, String> nameCol;
    @FXML
    private TableColumn<Patient, Integer> ageCol;
    @FXML
    private TableColumn<Patient, String> genderCol;
    @FXML
    private TableColumn<Patient, String> addressCol;
    @FXML
    private TableColumn<Patient, String> phoneCol;
    @FXML
    private TableColumn<Patient, String> diagnoseCol;

    @FXML
    private  TextField searchRoomtxt;



    // Dữ liệu giả lập cho phòng điều trị
    private ObservableList<TreatmentRoom> roomList;
    private ObservableList<Patient> patientList;

    private HospitalController hospitalController;

    public TreatmentRoomViewController() {
        this.hospitalController = HospitalController.getInstance();
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
            roomList = FXCollections.observableArrayList();
            patientList = FXCollections.observableArrayList();

            // Khởi tạo các giá trị cho TableColumn từ đối tượng Room
            colIdRoom.setCellValueFactory(new PropertyValueFactory<TreatmentRoom, Integer>("roomId"));
            colNameRoom.setCellValueFactory(new PropertyValueFactory<TreatmentRoom, String>("roomName"));
            colTypeRoom.setCellValueFactory(new PropertyValueFactory<TreatmentRoom, String>("roomType"));
            colCapacity.setCellValueFactory(new PropertyValueFactory<TreatmentRoom, Integer>("capacity"));

            hospitalController.addTreatmentRoom("phòng điều trị", "khám", 30);
            roomList.addAll(hospitalController.getListRoom());
            tableViewRoom.setItems(roomList);




            patientList = FXCollections.observableArrayList();


            //Cài đặt các cột cho bảng
            idCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientId"));
            nameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
            ageCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
            genderCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
            addressCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("address"));
            phoneCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("phone"));
            diagnoseCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("diagnose"));

            patientList.addAll(hospitalController.getListPatient());

            infoPatient.setItems(patientList);
    }

    @FXML
    public void displayAllPatient(ActionEvent e) {
        patientList = FXCollections.observableArrayList();

        patientList.addAll(hospitalController.getListPatient());

        infoPatient.setItems(patientList);
    }

    public void displayPatientInRoom(ActionEvent e) {
        TreatmentRoom treatmentSelect = tableViewRoom.getSelectionModel().getSelectedItem();
        if(treatmentSelect != null) {

            patientList = FXCollections.observableArrayList();

            patientList.addAll(hospitalController.getPatientsInRoom(treatmentSelect.getRoomId()));

            infoPatient.setItems(patientList);
        } else {
            showAlert("Lỗi", "Hãy chọn phòng bệnh");
        }
    }

    public void addPatienToRoom(ActionEvent e) {
        Patient patientSelect = infoPatient.getSelectionModel().getSelectedItem();
        TreatmentRoom treatmentSelect = tableViewRoom.getSelectionModel().getSelectedItem();
        if (patientSelect != null && treatmentSelect != null) {
            hospitalController.assignPatientToRoom(patientSelect.getPatientId(), treatmentSelect.getRoomId());
        } else {
            showAlert("Lỗi", "Hãy chọn bệnh nhân và phòng bệnh cần thêm");
        }

    }

    public void searchRoom(ActionEvent e) {
        roomList = FXCollections.observableArrayList();
        int roomId = Integer.parseInt(searchRoomtxt.getText());
        if(hospitalController.findTreatmentRoom(roomId) != null) {
            roomList.add(hospitalController.findTreatmentRoom(roomId));
            tableViewRoom.setItems(roomList);
        } else {
            showAlert("", "Không tìm thấy phòng điều trị");
        }
    }

    public void displayAllRoom(ActionEvent e) {
        roomList = FXCollections.observableArrayList();
        try {
            roomList.addAll(hospitalController.getListRoom());
            tableViewRoom.setItems(roomList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    //Quay về trang chủ
    public void backToHome(ActionEvent e) throws IOException {
        Stage currentStage = (Stage) backHomeBtn.getScene().getWindow();//Lấy ra cái cửa sổ hiện tại
        BackToHome backToHome = new BackToHome();
        try {
            backToHome.goToHome(currentStage);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    // Hàm hiển thị thông báo lỗi
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
