package com.finalproj.Controller;

import com.finalproj.Modal.Patient;
import com.finalproj.Modal.TreatmentRoom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TreatmentRoomViewController {
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
    private ListView<Patient> listViewRoom;

    // Dữ liệu giả lập cho phòng điều trị
    private ObservableList<TreatmentRoom> roomList;

    private ObservableList<Patient> listPatientInRoom;

    HospitalController hospitalController = new HospitalController();


    @FXML
    public void initialize() {
        roomList = FXCollections.observableArrayList();
        listPatientInRoom = FXCollections.observableArrayList();

        // Khởi tạo các giá trị cho TableColumn từ đối tượng Room
        colIdRoom.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colNameRoom.setCellValueFactory(new PropertyValueFactory<>("roomName"));
        colTypeRoom.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        colCapacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));

        hospitalController.addTreatmentRoom("name", "name", 50);
        hospitalController.assignPatientToRoom(1, 1);

        roomList.addAll(hospitalController.getListRoom());


        // Gán dữ liệu cho TableView và ListView
        tableViewRoom.setItems(roomList);
    }

    public void displayListPatientsInRoom(ActionEvent e) {
        TreatmentRoom selected = tableViewRoom.getSelectionModel().getSelectedItem();

        if(selected != null) {
            // Xóa danh sách cũ trong listPatientInRoom để tránh trùng lặp dữ liệu
            listPatientInRoom.clear();

            // Lấy danh sách bệnh nhân từ phòng được chọn
            List<Patient> patientsInRoom = hospitalController.getPatientsInRoom(selected.getRoomId());


            // Thêm các đối tượng bệnh nhân vào ObservableList<Patient>
            listPatientInRoom.addAll(patientsInRoom);
        }
        listViewRoom.setItems(listPatientInRoom);


    }



}
