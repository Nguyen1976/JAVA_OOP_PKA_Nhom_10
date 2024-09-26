package com.finalproj.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class LogOut {
    public void logOut(Stage currentStage) throws IOException {
        // Tạo hộp thoại xác nhận
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận đăng xuất");
        alert.setHeaderText("Bạn có chắc chắn muốn đăng xuất?");
        alert.setContentText("Nhấn OK để đăng xuất, hoặc Cancel để trở lại.");

        // Hiển thị hộp thoại
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                // Tải file FXML của trang chủ
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/finalproj/LoginView.fxml"));
                Parent loginView = loader.load();

                Scene loginScene = new Scene(loginView);

                currentStage.setScene(loginScene);

                currentStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
