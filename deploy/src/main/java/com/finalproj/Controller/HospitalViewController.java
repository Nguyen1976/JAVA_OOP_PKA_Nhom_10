package com.finalproj.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HospitalViewController {

    @FXML
    private void changeSceneAddPatient(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/finalproj/PatientView.fxml"));
        Parent addPatientViewParent = loader.load();
        Scene scene = new Scene(addPatientViewParent);


        stage.setScene(scene);
    }
}
