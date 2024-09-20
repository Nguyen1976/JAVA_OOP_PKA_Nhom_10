package com.finalproj.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField account;
    @FXML
    private TextField password;

    private final String ACCOUNT = "1";
    private final String PASSWORD = "1";

    private boolean handleLogin() {
        if(account.getText().equals(ACCOUNT) && password.getText().equals(PASSWORD)) {
            // Đăng nhập thành công
            showAlert(Alert.AlertType.INFORMATION, "Đăng Nhập Thành Công", "Bạn đã đăng nhập thành công.");
            return true;
        } else {
            // Đăng nhập thất bại
            showAlert(Alert.AlertType.ERROR, "Đăng Nhập Thất Bại", "Tên đăng nhập hoặc mật khẩu không chính xác.");
            return false;
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void changeScene(ActionEvent e) throws IOException {
        if(handleLogin()) {
            Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/finalproj/HospitalView.fxml"));
            Parent hospitalViewParent = loader.load();
            Scene scene = new Scene(hospitalViewParent);

            stage.setScene(scene);
        }
    }
}
