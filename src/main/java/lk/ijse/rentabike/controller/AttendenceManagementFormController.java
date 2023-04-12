package lk.ijse.rentabike.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.rentabike.dto.Booking;
import lk.ijse.rentabike.dto.tm.BookingTm;
import lk.ijse.rentabike.model.BookingModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class AttendenceManagementFormController implements Initializable {
    private static final String URL = "jdbc:mysql://localhost:3306/rentabike";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    @FXML
    private JFXComboBox<?> cmbHoliday;

    @FXML
    private TableColumn<?, ?> colAttendencedId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colEmployeeId;

    @FXML
    private TableColumn<?, ?> colHoliday;

    @FXML
    private TableColumn<?, ?> colSignInTime;

    @FXML
    private TableColumn<?, ?> colSignOutTime;

    @FXML
    private DatePicker dtpkDate;

    @FXML
    private TableView<?> tblAttendenceManagement;

    @FXML
    private TextField txtAttendenceId;

    @FXML
    private TextField txtEmployeedId;

    @FXML
    private TextField txtSignInTime;

    @FXML
    private TextField txtSignOutTime;

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }

    private void setCellValueFactory() {
        colAttendencedId.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("chooseBike"));
        colHoliday.setCellValueFactory(new PropertyValueFactory<>("pickUpLocation"));
        colSignInTime.setCellValueFactory(new PropertyValueFactory<>("pickUpDate"));
        colSignOutTime.setCellValueFactory(new PropertyValueFactory<>("pickUpTime"));
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("dropOffLocation"));
    }

    private void getAll() {
        try {
            ObservableList<BookingTm> obList = FXCollections.observableArrayList();
            List<Booking> bookList = BookingModel.getAll();

            for (Booking booking : bookList) {
                obList.add(new BookingTm(
                        booking.getBookingId(),
                        booking.getChooseBike(),
                        booking.getPickUpLocation(),
                        booking.getPickUpDate(),
                        booking.getPickUpTime(),
                        booking.getDropOffLocation(),
                        booking.getDropOffDate(),
                        booking.getDropOffTime()
                ));
            }
            tblBooking.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
