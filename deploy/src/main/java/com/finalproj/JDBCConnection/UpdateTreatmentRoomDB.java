package com.finalproj.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.finalproj.JDBCConnection.DBConnection.getConnection;
public class UpdateTreatmentRoomDB {
    // Update treatment room information
    public static void updateTreatmentRoomDB(int roomId, String roomName, String roomType, int capacity, String patientsList, String query) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Connect to the database
            connection = getConnection();
            connection.setAutoCommit(false);  // Begin transaction

            // Update treatment room information
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, roomName);
            preparedStatement.setString(2, roomType);
            preparedStatement.setInt(3, capacity);
            preparedStatement.setString(4, patientsList);
            preparedStatement.setInt(5, roomId);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " updated in treatmentRoom table.");

            connection.commit();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
                System.err.println(e.getMessage());
            } catch (SQLException rollbackEx) {
                System.err.println(rollbackEx.getMessage());
            }
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException closeEx) {
                System.err.println(closeEx.getMessage());
            }
        }
    }
}


