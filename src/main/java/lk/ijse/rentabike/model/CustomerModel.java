package lk.ijse.rentabike.model;

import lk.ijse.rentabike.db.DBConnection;
import lk.ijse.rentabike.dto.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomerModel {
    private static final String URL = "jdbc:mysql://localhost:3306/rentabike";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public static List<Customer> getAll() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer";

        List<Customer> data = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            data.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9)
            ));
        }
        return data;
    }

    public static List<String> loadIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        ResultSet resultSet = con.createStatement().executeQuery("SELECT id FROM Customer");

        List<String> data = new ArrayList<>();

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }

    public static Customer searchById(String id) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = con.prepareStatement("SELECT * FROM Customer WHERE id = ?");
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return  new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9)
            );
        }
        return null;
    }

    public static boolean save(Customer customer) throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "INSERT INTO Customer (customerId, name, age, contact, email, address, city, country,zip_code)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, customer.getCustomerId());
            pstm.setString(2, customer.getFullName());
            pstm.setInt(3, customer.getAge());
            pstm.setString(4, customer.getPhoneNumber());
            pstm.setString(5, customer.getEmail());
            pstm.setString(6, customer.getAddress());
            pstm.setString(7, customer.getCity());
            pstm.setString(8, customer.getCountry());
            pstm.setString(9, customer.getZipCode());

            return pstm.executeUpdate() > 0;
        }
    }

    public static boolean update(String CustomerId, String Fullname, int Age, String PhoneNumber, String Email, String Address, String City, String Country, String Zipcode) throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "UPDATE Customer SET name = ?, age = ?, contact = ?, email = ?, address = ?, city = ?, country = ?, zip_code = ? WHERE customerId = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, Fullname);
            pstm.setInt(2, Age);
            pstm.setString(3, PhoneNumber);
            pstm.setString(4, Email);
            pstm.setString(5, Address);
            pstm.setString(6, City);
            pstm.setString(7, Country);
            pstm.setString(8, Zipcode);
            pstm.setString(9, CustomerId);

            return pstm.executeUpdate() > 0;
        }
    }

    public static boolean delete(String CustomerId) throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "DELETE FROM Customer WHERE customerId = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, CustomerId);

            return pstm.executeUpdate() > 0;
        }
    }

    public static Customer search(String code) throws SQLException {
        try (Connection con = DBConnection.getInstance().getConnection()) {
            String sql = "SELECT * FROM Customer WHERE customerId = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, code);

            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()) {
                return new Customer(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9)

                );
            }
            return null;
        }
    }

    public static boolean validateCustomerId(String customerId) {
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String query = "SELECT * FROM Customer WHERE customerId = ?";
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
