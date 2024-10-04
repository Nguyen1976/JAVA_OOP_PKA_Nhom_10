package com.finalproj.Controller;

import com.finalproj.JDBCConnection.DBConnection;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.InputStream;
import java.util.Scanner;

public class LoginViewController {
    @FXML
    private TextField account;
    @FXML
    private TextField password;

//    private String ACCOUNT;
//    private String PASSWORD;

    //    // Đọc tài khoản và mật khẩu từ file trong package com.finalproj.datafiles
//    private void loadCredentials() throws IOException {
//        InputStream inputStream = getClass().getResourceAsStream("/com/finalproj/datafiles/credentials.txt");
//
//        if (inputStream == null) {
//            showAlert(Alert.AlertType.ERROR, "File không tìm thấy", "Không thể tìm thấy file credentials.txt.");
//        } else {
//            Scanner scanner = new Scanner(inputStream);
//            if (scanner.hasNextLine()) {
//                String[] credentials = scanner.nextLine().split(" ");
//                if (credentials.length == 2) {
//                    ACCOUNT = credentials[0];
//                    PASSWORD = credentials[1];
//                }
//            }
//            scanner.close();
//        }
//    }
    private boolean handleLogin() {
        String inputAccount = account.getText();
        String inputPassword = password.getText();

        // Kết nối tới database và kiểm tra tài khoản
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM Login WHERE userName = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, inputAccount);
            statement.setString(2, inputPassword);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Đăng nhập thành công
                showAlert(Alert.AlertType.INFORMATION, "Đăng Nhập Thành Công", "Bạn đã đăng nhập thành công.");
                return true;
            } else {
                // Đăng nhập thất bại
                showAlert(Alert.AlertType.ERROR, "Đăng Nhập Thất Bại", "Tên đăng nhập hoặc mật khẩu không chính xác.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Lỗi Cơ Sở Dữ Liệu", "Có lỗi khi kết nối tới cơ sở dữ liệu.");
            return false;
        }
    }



    // Kiểm tra đăng nhập
//    private boolean handleLogin() throws IOException {
//        loadCredentials();
//        if (account.getText().equals(ACCOUNT) && password.getText().equals(PASSWORD)) {
//            // Đăng nhập thành công
//            showAlert(Alert.AlertType.INFORMATION, "Đăng Nhập Thành Công", "Bạn đã đăng nhập thành công.");
//            return true;
//        } else {
//            // Đăng nhập thất bại
//            showAlert(Alert.AlertType.ERROR, "Đăng Nhập Thất Bại", "Tên đăng nhập hoặc mật khẩu không chính xác.");
//            return false;
//        }
//    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void changeScene(ActionEvent e) throws IOException {
        try {
            if(handleLogin()) {
                Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/finalproj/HospitalView.fxml"));
                Parent hospitalViewParent = loader.load();
                Scene scene = new Scene(hospitalViewParent);

                stage.setScene(scene);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}
