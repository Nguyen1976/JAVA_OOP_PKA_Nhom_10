package com.finalproj.JDBCConnection;


import com.finalproj.JDBCConnection.DBConnection;
import com.finalproj.Modal.Patient;
import com.finalproj.Modal.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    // Lấy danh sách tất cả bệnh nhân và truyền vào ArrayList
    public ArrayList<Patient> getAllPatients() {
        String query = "SELECT * FROM Patient";
        ArrayList<Patient> patientsList = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setPatientId(resultSet.getInt("patientId"));
                patient.setName(resultSet.getString("name"));
                patient.setAge(resultSet.getInt("age"));
                patient.setGender(resultSet.getString("gender"));
                patient.setDiagnose(resultSet.getString("diagnose"));

                // Lấy thông tin địa chỉ và tạo đối tượng Address
                Address address = new Address(resultSet.getString("city"), resultSet.getString("district"));
                patient.setAddress(address);

                patient.setPhone(resultSet.getString("phone"));

                // Thêm đối tượng Patient vào ArrayList
                patientsList.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patientsList;
    }
}
