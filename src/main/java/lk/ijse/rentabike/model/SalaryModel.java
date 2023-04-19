package lk.ijse.rentabike.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import lk.ijse.rentabike.db.DBConnection;
import lk.ijse.rentabike.dto.Salary;
import lk.ijse.rentabike.dto.tm.SalaryTm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SalaryModel {
    private static final String URL = "jdbc:mysql://localhost:3306/rentabike";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public static List<Salary> getAll() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Salaries";

        List<Salary> data = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            data.add(new Salary(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)

            ));
        }
        return data;
    }

    /*public static boolean save(Salary salary) throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "INSERT INTO Salaries (salaryId, description, amount, type, month, employeeId) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, salary.getSalaryId());
            pstm.setString(2, salary.getDescription());
            pstm.setDouble(3, salary.getAmount());
            pstm.setString(4, salary.getType());
            pstm.setString(5, salary.getEmployeeId());

            return pstm.executeUpdate() > 0;
        }
    }*/

    public static boolean validateSalaryId(String salaryId) {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String query = "SELECT * FROM Salaries WHERE salaryId = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, salaryId);
            ResultSet rs = pstm.executeQuery();
            return !rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
