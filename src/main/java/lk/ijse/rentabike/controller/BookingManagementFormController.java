package lk.ijse.rentabike.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.rentabike.dto.Booking;
import lk.ijse.rentabike.dto.Customer;
import lk.ijse.rentabike.dto.tm.BookingTm;
import lk.ijse.rentabike.dto.tm.CustomerTM;
import lk.ijse.rentabike.model.BookingModel;
import lk.ijse.rentabike.model.CustomerModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class BookingManagementFormController implements Initializable {
    private static final String URL = "jdbc:mysql://localhost:3306/rentabike";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public TableView<BookingTm> tblBooking;
    public TableColumn colBookingId;
    public TableColumn colBikeType;
    public TableColumn colPickuplocation;
    public TableColumn colPickupdate;
    public TableColumn colPickuptime;
    public TableColumn colDropofflocation;
    public TableColumn colDropoffdate;
    public TableColumn colDropofftime;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }

    private void setCellValueFactory() {
        colBookingId.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        colBikeType.setCellValueFactory(new PropertyValueFactory<>("chooseBike"));
        colPickuplocation.setCellValueFactory(new PropertyValueFactory<>("pickUpLocation"));
        colPickupdate.setCellValueFactory(new PropertyValueFactory<>("pickUpDate"));
        colPickuptime.setCellValueFactory(new PropertyValueFactory<>("pickUpTime"));
        colDropofflocation.setCellValueFactory(new PropertyValueFactory<>("dropOffLocation"));
        colDropoffdate.setCellValueFactory(new PropertyValueFactory<>("dropOffDate"));
        colDropofftime.setCellValueFactory(new PropertyValueFactory<>("dropOffTime"));
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
}