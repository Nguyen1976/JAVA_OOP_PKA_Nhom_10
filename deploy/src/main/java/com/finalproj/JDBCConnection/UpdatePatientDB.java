package com.finalproj.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.finalproj.JDBCConnection.DBConnection.getConnection;

public class UpdatePatientDB {

    // Update patient information
    public static void updatePatientInfo(int patientId, String name, int age, String gender, String diagnose,
                                         String city, String district, String phone, String query, String query2) {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;

        try {
            // Connect to the database
            connection = getConnection();
            connection.setAutoCommit(false);

            // Update patient information
            preparedStatement1 = connection.prepareStatement(query);
            preparedStatement1.setString(1, name);
            preparedStatement1.setInt(2, age);
            preparedStatement1.setString(3, gender);
            preparedStatement1.setString(4, diagnose);
            preparedStatement1.setString(5, city);
            preparedStatement1.setString(6, district);
            preparedStatement1.setString(7, phone);
            preparedStatement1.setInt(8, patientId);

            int rowsAffected1 = preparedStatement1.executeUpdate();
            System.out.println(rowsAffected1 + " record(s) updated in patient table.");

            // Execute script2 if provided
            if (!query2.isEmpty()) {
                preparedStatement2 = connection.prepareStatement(query2);
                preparedStatement2.setInt(1, patientId);
                int rowsAffected2 = preparedStatement2.executeUpdate();
                System.out.println(rowsAffected2 + " record(s) updated in related table.");
            }

            connection.commit();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
                System.err.println("Transaction rolled back due to error: " + e.getMessage());
            } catch (SQLException rollbackEx) {
                System.err.println("Error during rollback: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                if (preparedStatement1 != null) {
                    preparedStatement1.close();
                }
                if (preparedStatement2 != null) {
                    preparedStatement2.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException closeEx) {
                System.err.println("Error closing resources: " + closeEx.getMessage());
            }
        }
    }
}
