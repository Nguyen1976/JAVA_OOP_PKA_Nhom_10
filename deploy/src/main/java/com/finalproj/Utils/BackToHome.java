package com.finalproj.Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BackToHome {
    public void goToHome(Stage currentStage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/finalproj/HospitalView.fxml"));
            Parent homeView = loader.load();

            Scene homeScene = new Scene(homeView);

            currentStage.setScene(homeScene);

            currentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
