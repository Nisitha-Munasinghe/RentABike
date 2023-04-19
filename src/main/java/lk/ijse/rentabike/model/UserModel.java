package lk.ijse.rentabike.model;

import java.sql.*;
import java.util.Properties;

public class UserModel {
    private static final String URL = "jdbc:mysql://localhost:3306/seew";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public static boolean validateUsernameANDpassword(String Username) {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String query = "SELECT * FROM User WHERE user_name = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, Username);
            ResultSet rs = pstm.executeQuery();
            return !rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
