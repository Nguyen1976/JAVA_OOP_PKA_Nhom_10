package com.finalproj.Controller;

import com.finalproj.Modal.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientViewController implements Initializable {
    @FXML
    private TextField namePatient;
    @FXML
    private TextField agePatient;
    @FXML
    private TextField maleGender;
    @FXML
    private TextField femaleGender;
    @FXML
    private TextField diagnosePatient;
    @FXML
    private TextField districtPatient;
    @FXML
    private TextField cityPatient;
    @FXML
    private TextField phonePatient;
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

    HospitalController hospitalController = new HospitalController();

    private ObservableList<Patient> patientList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patientList = FXCollections.observableArrayList();

        idCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("ID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("Tên"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("Tuổi"));
        genderCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("Giới tính"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("Địa chỉ"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("Số điện thoại"));
        diagnoseCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("Chẩn đoán"));

        patientList.addAll(hospitalController.getListPatient());

        infoPatient.setItems(patientList);
    }

    public void addPatient(ActionEvent e) {

    }
}
