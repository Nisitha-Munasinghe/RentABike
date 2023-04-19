package lk.ijse.rentabike.model;


import lk.ijse.rentabike.db.DBConnection;
import lk.ijse.rentabike.dto.Attendence;
import lk.ijse.rentabike.dto.tm.AttendenceTm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AttendenceModel {
    private static final String URL = "jdbc:mysql://localhost:3306/rentabike";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public static List<Attendence> getAll() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Attendance";

        List<Attendence> data = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            data.add(new Attendence(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            ));
        }
        return data;
    }

    public static boolean validateAttendenceId(String customerId) {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String query = "SELECT * FROM Booking WHERE bookingId = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, customerId);
            ResultSet rs = pstm.executeQuery();
            return !rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
