package lk.ijse.rentabike.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.rentabike.dto.Customer;
import lk.ijse.rentabike.dto.tm.CustomerTM;
import lk.ijse.rentabike.model.CustomerModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class CustomerManagementFormController implements Initializable {
    public JFXButton dashboardbtn;
    public JFXButton bookingbtn;
    public JFXButton vehiclebtn;
    public JFXButton customerbtn;
    public JFXButton employeebtn;
    public JFXButton billingbtn;
    public JFXButton settingbtn;
    public JFXButton logoutbtn;

    public TableView<CustomerTM> tblCustomer;
    public TableColumn colCustomerId;
    public TableColumn colFullame;
    public TableColumn colAge;
    public TableColumn colContact;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colCity;
    public TableColumn colCountry;
    public TableColumn colZipcode;
    public JFXButton reportbtn;


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
    }

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"));
        Stage window = (Stage)dashboardbtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Dashboard");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnBookingOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/BookingPart1Filling.fxml"));
        Stage window = (Stage)bookingbtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Booking");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnVehicleOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/VehiclePreviewForm.fxml"));
        Stage window = (Stage)vehiclebtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Vehicle Preview");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/CustomerManagementForm.fxml"));
        Stage window = (Stage)customerbtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Customer Management");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnEmployeeManagementOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/EmployeeManagementForm.fxml"));
        Stage window = (Stage)employeebtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Employee Management");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnBillingOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/PaymentsManagementForm.fxml"));
        Stage window = (Stage)billingbtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Payments Management");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnReportOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/reportManageForm.fxml"));
        Stage window = (Stage)reportbtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Reports");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnSettingOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/SettingForm.fxml"));
        Stage window = (Stage)settingbtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Setting");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/LogOutPageForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Logout page");
        stage.centerOnScreen();
        stage.show();
        currentStage.close();
    }

    public void btnEditCustomerPageOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/CustomerInformationForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Booking Management");
        stage.setMaximized(true);
        stage.centerOnScreen();
        stage.show();
    }
}
