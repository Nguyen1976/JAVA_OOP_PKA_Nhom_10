package com.finalproj.JDBCConnection;

import com.finalproj.Modal.TreatmentRoom;

import java.sql.*;
import java.util.ArrayList;

public class TreatmentRoomDAO {

    public ArrayList<TreatmentRoom> getAllTreatmentRooms() {
        String query = "SELECT * FROM TreatmentRoom";
        ArrayList<TreatmentRoom> treatmentRoomsList = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                // Tạo đối tượng TreatmentRoom từ kết quả truy vấn
                TreatmentRoom room = new TreatmentRoom();
                room.setRoomId(resultSet.getInt("roomId"));
                room.setRoomName(resultSet.getString("roomName"));
                room.setRoomType(resultSet.getString("roomType"));
                room.setCapacity(resultSet.getInt("capacity"));

                // Thêm phòng điều trị vào danh sách
                treatmentRoomsList.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return treatmentRoomsList;

    }
}
