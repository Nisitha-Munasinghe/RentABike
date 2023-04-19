package lk.ijse.rentabike.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.rentabike.dto.Salary;
import lk.ijse.rentabike.dto.tm.SalaryTm;
import lk.ijse.rentabike.model.SalaryModel;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class SalaryManagementFormController implements Initializable {

    private static final String URL = "jdbc:mysql://localhost:3306/rentabike";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    @FXML
    public TableColumn colMonth;
    public TextField txtMonth;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colEmployeeId;

    @FXML
    private TableColumn<?, ?> colSalaryId;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableView<SalaryTm> tblSalary;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtEmployeeId;

    @FXML
    private TextField txtSalaryId;

    @FXML
    private TextField txtType;

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }

    private void setCellValueFactory() {
        colSalaryId.setCellValueFactory(new PropertyValueFactory<>("salaryId"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
    }

    private void getAll() {
        try {
            ObservableList<SalaryTm> obSList = FXCollections.observableArrayList();
            List<Salary> salList = SalaryModel.getAll();

            for (Salary salary : salList) {
                obSList.add(new SalaryTm(
                        salary.getSalaryId(),
                        salary.getDescription(),
                        salary.getAmount(),
                        salary.getType(),
                        salary.getMonth(),
                        salary.getEmployeeId()
                ));
            }
            tblSalary.setItems(obSList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event)  throws SQLException {
        String SalaryId = txtSalaryId.getText();
        String description = txtDescription.getText();
        double Amount = Double.parseDouble(txtAmount.getText());
        String type = txtType.getText();
        String month = txtMonth.getText();
        String EmployeeId = txtEmployeeId.getText();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "INSERT INTO Salaries(salaryId, description, amount, type, month, employeeId)" +
                    "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, SalaryId);
            pstm.setString(2, description);
            pstm.setDouble(3, Amount);
            pstm.setString(4, type);
            pstm.setString(5, month);
            pstm.setString(6, EmployeeId);

            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0) {
                new Alert(Alert.AlertType.CONFIRMATION,
                        "salary added :)")
                        .show();
            }
        }


        /*Salary salary = new Salary(SalaryId, description, Amount, type, EmployeeId);

        try {
            boolean isSaved = SalaryModel.save(salary);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }*/

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException {
        String SalaryId = txtSalaryId.getText();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "DELETE FROM Salaries WHERE salaryId = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, SalaryId);

            if (pstm.executeUpdate() > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "deletd!").show();
            }
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {
        String SalaryId = txtSalaryId.getText();
        String description = txtDescription.getText();
        double Amount = Double.parseDouble(txtAmount.getText());
        String type = txtType.getText();
        String month = txtMonth.getText();
        String EmployeeId = txtEmployeeId.getText();


        if (salaryFormatValidation(SalaryId)) {
            if (amountValidation(Amount)) {
                if (typeValidation(type)) {
                    if (monthValidation(month)) {

                        try (Connection con = DriverManager.getConnection(URL, props)) {
                            String sql = "UPDATE Salaries SET description = ?, amount = ?, type = ?, month = ?, employeeId = ? WHERE salaryId = ?";
                            PreparedStatement pstm = con.prepareStatement(sql);
                            pstm.setString(1, description);
                            pstm.setDouble(2, Amount);
                            pstm.setString(3, type);
                            pstm.setString(4, month);
                            pstm.setString(5, EmployeeId);
                            pstm.setString(6, SalaryId);

                            boolean isUpdated = pstm.executeUpdate() > 0;
                            if (isUpdated) {
                                new Alert(Alert.AlertType.CONFIRMATION, " updated!!").show();
                            }
                        }

                    } else {
                        new Alert(Alert.AlertType.WARNING,"Invalid month. Must be a valid month abbreviation (Jan-Dec).").show();
                    }
                } else {
                    new Alert(Alert.AlertType.WARNING,"Invalid type. Must be a single character.").show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING,"Invalid amount. Must be a valid number.").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING,"Invalid salary ID. Must be in the format s001, s002, s0011.").show();
        }

    }

    public boolean monthValidation(String month) {
        List<String> validMonths = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        if (!validMonths.contains(month)) {
            return false;
        }
        return true;
    }


    public boolean typeValidation(String type) {
        if (!type.matches("^[a-zA-Z]$")) {

            return false;
        }
        return true;
    }


    public boolean amountValidation(double amountStr) {
        double amount;
        try {
            amount = amountStr;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean salaryFormatValidation(String salaryId) {
        if (!salaryId.matches("^s\\\\d{3,4}$")) {
            return false;
        }
        return true;
    }


    public void codeSearchOnAction(ActionEvent actionEvent) throws SQLException {
        String SalaryId = txtSalaryId.getText();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "SELECT * FROM Salaries WHERE salaryId = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, SalaryId);

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                String sal_SalaryId = resultSet.getString(1);
                String sal_description = resultSet.getString(2);
                double sal_Amount = resultSet.getDouble(3);
                String sal_type = resultSet.getString(4);
                String sal_month = resultSet.getString(5);
                String sal_EmployeeId = resultSet.getString(6);


                txtSalaryId.setText(sal_SalaryId);
                txtDescription.setText(sal_description);
                txtAmount.setText(String.valueOf(sal_Amount));
                txtType.setText(sal_type);
                txtMonth.setText(sal_month);
                txtEmployeeId.setText(sal_EmployeeId);

            }
        }
    }
}
