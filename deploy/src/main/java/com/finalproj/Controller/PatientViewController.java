package com.finalproj.Controller;

import com.finalproj.JDBCConnection.PatientDAO;
import com.finalproj.Modal.Address;
import com.finalproj.Modal.Patient;
import com.finalproj.Utils.BackToHome;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientViewController extends HospitalController implements Initializable {
    @FXML
    private TextField searchPatient;
    @FXML
    private Button backHomeBtn;
    @FXML
    private TextField namePatient;
    @FXML
    private TextField agePatient;
    @FXML
    private RadioButton maleGender;
    @FXML
    private RadioButton femaleGender;
    @FXML
    private TextArea diagnosePatient;
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

    // Thêm nhóm ToggleGroup để xử lý lựa chọn giới tính
    private ToggleGroup genderGroup;

    private PatientDAO patientDao;  // Thêm đối tượng PatientDao để tương tác với DB



//    HospitalController hospitalController = new HospitalController();

    private ObservableList<Patient> patientList;

    private HospitalController hospitalController;

    public PatientViewController() {
        this.hospitalController = HospitalController.getInstance();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patientList = FXCollections.observableArrayList();


        //Cài đặt các cột cho bảng
        idCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("patientId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
        ageCol.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
        genderCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("address"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("phone"));
        diagnoseCol.setCellValueFactory(new PropertyValueFactory<Patient, String>("diagnose"));


        hospitalController.initializePatientList();
        patientList.addAll(hospitalController.getListPatient());
        infoPatient.setItems(patientList);

        // Thiết lập nhóm ToggleGroup để chỉ chọn 1 radio button tại 1 thời điểm
        genderGroup = new ToggleGroup();
        maleGender.setToggleGroup(genderGroup);
        femaleGender.setToggleGroup(genderGroup);
    }

    public void addPatient(ActionEvent e) {
        // Lấy dữ liệu từ các trường nhập
        String name = namePatient.getText();
        String ageText = agePatient.getText();
        String diagnose = diagnosePatient.getText();
        String district = districtPatient.getText();
        String city = cityPatient.getText();
        String phone = phonePatient.getText();

        Address address = new Address(city, district);
        // Lấy giá trị từ RadioButton (Giới tính)
        String gender = "";
        if (maleGender.isSelected()) {
            gender = "Nam";
        } else if (femaleGender.isSelected()) {
            gender = "Nữ";
        }

        // Xử lý kiểm tra các trường (tuổi phải là số)
        if (name.isEmpty() || ageText.isEmpty() || gender.isEmpty() || diagnose.isEmpty() || phone.isEmpty()) {
            showAlert("Lỗi", "Vui lòng điền đầy đủ thông tin");
            return;
        }

        if(!isInteger(ageText)) {
            showAlert("Lỗi", "Tuổi phải là số");
            return;
        }




        try {
            int age = Integer.parseInt(ageText); // Chuyển đổi tuổi thành số



            //Thêm bệnh nhân vào arraylisst
            hospitalController.addPatient(name, age, gender, diagnose, address, phone, 0);
            hospitalController.initializePatientList();


            // Thêm bệnh nhân vào danh sách và cập nhật bảng
            patientList.setAll(hospitalController.getListPatient());
            infoPatient.setItems(patientList);

            // Xóa dữ liệu trong các trường nhập
            clearFields();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deletePatient(ActionEvent e) {
        Patient selected = infoPatient.getSelectionModel().getSelectedItem();
        if(selected != null) {
            hospitalController.deletePatient(selected.getPatientId());
            hospitalController.initializePatientList();
            patientList.setAll(hospitalController.getListPatient());
        } else {
            showAlert("Lỗi", "Vui lòng chọn bệnh nhân để xóa");
            return;
        }
    }

    public void updatePatient(ActionEvent e) {
        // Lấy bệnh nhân được chọn trong bảng
        Patient selected = infoPatient.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Lỗi", "Vui lòng chọn bệnh nhân để sửa");
            return;
        }

        // Điền thông tin vào các trường nhập
        namePatient.setText(selected.getName());
        agePatient.setText(String.valueOf(selected.getAge()));
        diagnosePatient.setText(selected.getDiagnose());
        districtPatient.setText(selected.getAddress().getDistrict());
        cityPatient.setText(selected.getAddress().getCity());
        phonePatient.setText(selected.getPhone());

        // Chọn giới tính tương ứng
        if (selected.getGender().equals("Nam")) {
            maleGender.setSelected(true);
        } else {
            femaleGender.setSelected(true);
        }
    }

    public void savePatient(ActionEvent e) {
        Patient selected = infoPatient.getSelectionModel().getSelectedItem();

        // Lấy dữ liệu từ các trường nhập
        String name = namePatient.getText();
        String ageText = agePatient.getText();
        String diagnose = diagnosePatient.getText();
        String district = districtPatient.getText();
        String city = cityPatient.getText();
        String phone = phonePatient.getText();

        // Lấy giới tính từ RadioButton
        String gender = maleGender.isSelected() ? "Nam" : "Nữ";

        // Kiểm tra các trường nhập
        if (name.isEmpty() || ageText.isEmpty() || gender.isEmpty() || diagnose.isEmpty() || phone.isEmpty()) {
            showAlert("Lỗi", "Vui lòng điền đầy đủ thông tin");
            return;
        }

        try {
            Address address = new Address(city, district);

            int age = Integer.parseInt(ageText); // Chuyển đổi tuổi thành số

            hospitalController.updatePatient(selected.getPatientId(), name, age, gender, diagnose, address, phone);
            hospitalController.initializePatientList();

            // Thêm bệnh nhân vào danh sách và cập nhật bảng
            patientList.setAll(hospitalController.getListPatient());
            infoPatient.setItems(patientList);

            clearFields();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void searchPatient(ActionEvent e) {
        try {
            if (searchPatient.getText().isEmpty()) {
                // Nếu không có từ khóa tìm kiếm, hiển thị toàn bộ danh sách
                showAlert("Lỗi", "Hãy nhập ID cần tìm kiếm");
                infoPatient.setItems(patientList);
                return;
            }

            Integer searchId = Integer.parseInt(searchPatient.getText());
            // Tìm bệnh nhân với ID
            Patient foundPatient = hospitalController.findPatient(searchId);

            if(foundPatient == null) {
                showAlert("Lỗi", "Không có bệnh nhân cần tìm kiếm");

                // Hiển thị all bệnh nhân khi k tìm thấy
                patientList.setAll(hospitalController.getListPatient());
                infoPatient.setItems(patientList);
            } else {
                // Tạo danh sách tạm thời và thêm bệnh nhân tìm được
                ObservableList<Patient> filteredList = FXCollections.observableArrayList();
                filteredList.add(foundPatient);

                // Cập nhật bảng với danh sách bệnh nhân đã lọc
                infoPatient.setItems(filteredList);
            }
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



    //---------------Method dùng chung-------------------------------
    // Phương thức kiểm tra nếu chuỗi là số nguyên
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true; // Nếu chuyển đổi thành công, chuỗi là số nguyên
        } catch (NumberFormatException e) {
            return false; // Nếu có lỗi, chuỗi không phải là số nguyên
        }
    }

    // Hàm để xóa các trường nhập sau khi thêm bệnh nhân
    private void clearFields() {
        namePatient.clear();
        agePatient.clear();
        diagnosePatient.clear();
        districtPatient.clear();
        cityPatient.clear();
        phonePatient.clear();
        genderGroup.selectToggle(null); // Bỏ chọn giới tính
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
