package lk.ijse.rentabike.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.rentabike.dto.Customer;
import lk.ijse.rentabike.dto.tm.CustomerTM;
import lk.ijse.rentabike.model.CustomerModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class SalaryManagementFormController{
    /*public TableView tblSalary;
    public TableColumn colSalaryId;
    public TableColumn colDescription;
    public TableColumn colAmount;
    public TableColumn colType;
    public TableColumn colEmployeeId;

    private static final String URL = "jdbc:mysql://localhost:3306/rentabike";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public TableView<CustomerTM> tblCustomer;

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }

    private void setCellValueFactory() {
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colFullame.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        colZipcode.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
    }

    private void getAll() {
        try {
            ObservableList<CustomerTM> obList = FXCollections.observableArrayList();
            List<Customer> cusList = CustomerModel.getAll();

            for (Customer customer : cusList) {
                obList.add(new CustomerTM(
                        customer.getCustomerId(),
                        customer.getFullName(),
                        customer.getAge(),
                        customer.getPhoneNumber(),
                        customer.getEmail(),
                        customer.getAddress(),
                        customer.getCity(),
                        customer.getCountry(),
                        customer.getZipCode()
                ));
            }
            tblCustomer.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }*/
}
