package com.finalproj.Controller;

import com.finalproj.Utils.LogOut;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HospitalViewController {
    @FXML
    private Button logoutBtn;
    @FXML
    private void changeSceneAddPatient(ActionEvent e) throws IOException {
        try {
            Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/finalproj/PatientView.fxml"));
            Parent addPatientViewParent = loader.load();
            Scene scene = new Scene(addPatientViewParent);


            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void changeSceneRoom(ActionEvent e) throws IOException {
        try {
            Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/finalproj/TreatmentRoomView.fxml"));
            Parent treatmentRoom = loader.load();
            Scene scene = new Scene(treatmentRoom);


            stage.setScene(scene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void logout(ActionEvent e) throws IOException {
        Stage currentStage = (Stage) logoutBtn.getScene().getWindow();//Lấy ra cái cửa sổ hiện tại
        LogOut logout = new LogOut();
        try {
            logout.logOut(currentStage);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
