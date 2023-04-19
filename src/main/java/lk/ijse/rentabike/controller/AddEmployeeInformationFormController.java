package lk.ijse.rentabike.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.Properties;

public class AddEmployeeInformationFormController {
    private static final String URL = "jdbc:mysql://localhost:3306/rentabike";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public TextField txtEmployeeTyped;


    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEmployeeId;

    @FXML
    private TextField txtEmployeeName;

    @FXML
    private TextField txtNic;

    @FXML
    void btnAddOnAction(ActionEvent event)  throws SQLException {
        String EmployeeId = txtEmployeeId.getText();
        String EmployeeTyped = txtEmployeeTyped.getText();
        String EmployeeName = txtEmployeeName.getText();
        String Contact = txtContact.getText();
        String Nic = txtNic.getText();
        String Address = txtAddress.getText();
        String Email = txtEmail.getText();

        if (employeeIdFormatValidation(EmployeeId)) {
            if (nameValidation(EmployeeName)) {
                if (addressValidation(Address)) {
                    if (contactValidation(Contact)) {
                        if (emailValidation(Email)) {

                            try (Connection con = DriverManager.getConnection(URL, props)) {
                                String sql = "INSERT INTO Employee(employeeId, employeeTyped ,name, nic, address, contact, email)" +
                                        "VALUES(?, ?, ?, ?, ?, ?, ?)";
                                PreparedStatement pstm = con.prepareStatement(sql);
                                pstm.setString(1, EmployeeId);
                                pstm.setString(2, EmployeeTyped);
                                pstm.setString(3, EmployeeName);
                                pstm.setString(4, Contact);
                                pstm.setString(5, Nic);
                                pstm.setString(6, Address);
                                pstm.setString(7, Email);

                                int affectedRows = pstm.executeUpdate();
                                if (affectedRows > 0) {
                                    new Alert(Alert.AlertType.CONFIRMATION,
                                            "employee added :)")
                                            .show();
                                }
                            }

                        }else {
                            new Alert(Alert.AlertType.WARNING,"Invalid email address. Must be in the format example@example.com.").show();
                        }
                    }else {
                        new Alert(Alert.AlertType.WARNING,"Invalid contact number. Must contain only numbers and an optional '+' sign.").show();
                    }
                }else {
                    new Alert(Alert.AlertType.WARNING,"Invalid address. Must contain at least 10 characters.").show();
                }
            }else {
                new Alert(Alert.AlertType.WARNING,"Invalid employee name. Must contain only alphabetic characters.").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING,"Invalid employee ID. Must be in the format ep001, ep002, ep011.").show();
        }


    }

    public boolean emailValidation(String email) {
        if (!email.matches("^\\S+@\\S+\\.com$")) {
            return false;
        }
        return true;
    }


    public boolean addressValidation(String address) {
        if (address.length() < 10) {
            return false;
        }
        return true;
    }


    public boolean employeeIdFormatValidation(String employeeId) {
        if (!employeeId.matches("^ep\\d{3,4}$")) {
            return false;
        }
        return true;
    }

    public boolean nameValidation(String name) {
        if (!name.matches("^[a-zA-Z]+$")) {
            return false;
        }
        return true;
    }

    public boolean contactValidation(String contact) {
        if (!contact.matches("^\\+?[0-9]+$")) {
            return false;
        }
        return true;
    }



    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException {
        String EmployeeId = txtEmployeeId.getText();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "DELETE FROM Employee WHERE employeeId = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, EmployeeId);

            if (pstm.executeUpdate() > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "deletd!").show();
            }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {
        String EmployeeId = txtEmployeeId.getText();
        String EmployeeTyped = txtEmployeeTyped.getText();
        String EmployeeName = txtEmployeeName.getText();
        String Contact = txtContact.getText();
        String Nic = txtNic.getText();
        String Address = txtAddress.getText();
        String Email = txtEmail.getText();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "UPDATE Employee SET employeeTyped = ?, name = ?, nic = ?, address = ?, contact = ?, email = ? WHERE employeeId = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, EmployeeTyped);
            pstm.setString(2, EmployeeName);
            pstm.setString(3, Contact);
            pstm.setString(4, Nic);
            pstm.setString(5, Address);
            pstm.setString(6, Email);
            pstm.setString(7, EmployeeId);

            boolean isUpdated = pstm.executeUpdate() > 0;
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "updated!!").show();
            }
        }
    }

    @FXML
    void codeSearchOnAction(ActionEvent event) throws SQLException {
        String EmployeeId = txtEmployeeId.getText();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "SELECT * FROM Employee WHERE employeeId = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, EmployeeId);

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                String emp_EmployeeId = resultSet.getString(1);
                String emp_EmployeeTyped = resultSet.getString(1);
                String emp_EmployeeName = resultSet.getString(2);
                String emp_Contact = resultSet.getString(3);
                String emp_Nic = resultSet.getString(1);
                String emp_Address = resultSet.getString(2);
                String emp_Email = resultSet.getString(3);

                txtEmployeeId.setText(emp_EmployeeId);
                txtEmployeeTyped.setText(emp_EmployeeTyped);
                txtEmployeeName.setText(emp_EmployeeName);
                txtContact.setText(emp_Contact);
                txtNic.setText(emp_Nic);
                txtAddress.setText(emp_Address);
                txtEmail.setText(emp_Email);
            }
        }
    }

}
