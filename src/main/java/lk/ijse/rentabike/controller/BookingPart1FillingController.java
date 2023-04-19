package lk.ijse.rentabike.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.rentabike.model.BookingModel;
import lk.ijse.rentabike.model.CustomerModel;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;



public class BookingPart1FillingController implements Initializable {
    public JFXButton dashboardbtn;
    public JFXButton bookingbtn;
    public JFXButton vehiclebtn;
    public JFXButton customerbtn;
    public JFXButton employeebtn;
    public JFXButton billingbtn;
    public JFXButton settingbtn;
    public JFXButton logoutbtn;
    public Button BookingManagePagebtn;

    public JFXComboBox cmbChooseBike;
    public JFXComboBox cmbPickUpLocation;
    public JFXComboBox cmbPickUpTime;
    public JFXComboBox cmbDropOffLocation;
    public JFXComboBox cmbDropOffTime;
    public DatePicker dtpkPickUpLocation;
    public DatePicker dtpkDropOffLocation;
    public TextField txtBookingId;

    public TextField txtCustomerId;
    public TextField txtFullName;
    public TextField txtAge;
    public TextField txtPhoneNumber;
    public TextField txtEmail;
    public TextField txtAddress;
    public TextField txtCity;
    public TextField txtCountry;
    public TextField txtZipCode;



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
        /*Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/PaymentsManagementForm.fxml"));
        Stage window = (Stage)billingbtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Payments Management");
        window.setMaximized(true);
        window.centerOnScreen();*/
        setUi("PaymentsManagementForm",billingbtn);
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
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/LogOutPageForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Log out");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnBookingManagePageOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/BookingManagementForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Booking Management");
        stage.setMaximized(true);
        stage.centerOnScreen();
        stage.show();
    }

    private void setUi(String form, JFXButton btn) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/"+form+".fxml"));
        Stage window = (Stage)btn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle(form);
        window.setMaximized(true);
        window.centerOnScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> bikeList = FXCollections.observableArrayList();
        bikeList.add("Honda Dio 110 CC");
        bikeList.add("Honda X Blade");
        bikeList.add("Tuk Tuk 300CC");
        bikeList.add("Hero XPluse 200CC");
        bikeList.add("Honda Hornet 160 R");
        bikeList.add("Honda Navi 110 CC");
        bikeList.add("Honda XR 250");
        bikeList.add("Mountain Cycle");
        bikeList.add("Ladies Cycle");

        cmbChooseBike.setItems(bikeList);

        ObservableList<String> locationList = FXCollections.observableArrayList(
                "Sri Lanka Bike Rent, Negombo",
                "Negombo",
                "Mirissa",
                "Weligama",
                "Ella",
                "Hikkaduwa",
                "Galle",
                "Unawatuna",
                "Kandy",
                "Arugam Bay",
                "Sigiriya",
                "Kalpitiya",
                "Trincomalee",
                "Tangalle",
                "Dickwella",
                "Anuradhapura",
                "Kataragama",
                "Matara",
                "Jaffna",
                "Batticola",
                "Benthota",
                "Nuwara Eliya",
                "Polonnaruwa"
        );
        cmbPickUpLocation.setItems(locationList);
        cmbDropOffLocation.setItems(locationList);

        ObservableList<String> timeList = FXCollections.observableArrayList();
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j += 15) {
                String time = String.format("%02d:%02d", i, j);
                if (i < 12) {
                    time += " am";
                } else if (i == 12) {
                    time += " pm";
                } else {
                    time = String.format("%02d:%02d", i - 12, j) + " pm";
                }
                timeList.add(time);
            }
        }
        cmbPickUpTime.setItems(timeList);
        cmbDropOffTime.setItems(timeList);
    }

    /*public String generateBookingId() {
        String prefix = "B";
        int nextId = getNextBookingIdFromDatabase(); // retrieve next available booking ID from database
        String bookingId = prefix + String.format("%03d", nextId); // format next ID as "BXXX" with leading zeros
        return bookingId;
    }

    public int getNextBookingIdFromDatabase() {
        int nextId = 1; // default value if no bookings exist yet
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentabike", props)) {
            String sql = "SELECT MAX(CAST(SUBSTR(bookingId, 2) AS INTEGER)) FROM Booking";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int maxId = rs.getInt(1);
                if (maxId > 0) {
                    nextId = maxId + 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextId;
    }*/

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String customerId = txtCustomerId.getText();
        String fullName = txtFullName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String phoneNumber = txtPhoneNumber.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String country = txtCountry.getText();
        String zipCode = txtZipCode.getText();


        if (customerIdFormatValidation(customerId)) {
            if (CustomerModel.validateCustomerId(customerId)) {
                if (customerNameValidation(fullName)) {
                    if (customerAgeValidation(age)) {
                        if (customerEmailValidation(email)) {

                            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentabike", "root", "1234")) {
                                String sql = "INSERT INTO Customer (customerId, name, age, contact, email, address, city, country,zip_code)" +
                                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                                PreparedStatement pstm = con.prepareStatement(sql);
                                pstm.setString(1, customerId);
                                pstm.setString(2, fullName);
                                pstm.setInt(3, age);
                                pstm.setString(4, phoneNumber);
                                pstm.setString(5, email);
                                pstm.setString(6, address);
                                pstm.setString(7, city);
                                pstm.setString(8, country);
                                pstm.setString(9, zipCode);

                                int affectedRows = pstm.executeUpdate();
                                if (affectedRows > 0) {
                                    new Alert(Alert.AlertType.CONFIRMATION, "Success! Customer information has been saved.").show();
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                                new Alert(Alert.AlertType.ERROR, "Failed to save customer information. Please try again.").show();
                            }

                        } else {
                            new Alert(Alert.AlertType.WARNING,"Invalid email. Must contain an @ symbol.").show();
                        }
                    } else {
                        new Alert(Alert.AlertType.WARNING,"Invalid age. Must be a number between 0 and 999.").show();
                    }
                } else {
                    new Alert(Alert.AlertType.WARNING,"Invalid full name. Only letters and spaces allowed.").show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "The customer ID already exists, So use different customer Id").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING,"Invalid customer ID Format. Must be in the format c001, c002, c0011.").show();
        }

    }


    public boolean customerIdFormatValidation(String customerId) {
        if (!customerId.matches("^c\\d{3,4}$")) {
            return false;
        }
        return true;
    }



    public boolean customerNameValidation(String fullName) {
        if (!fullName.matches("^[a-zA-Z ]+$")) {
            return false;
        }
        return true;
    }



    public boolean customerAgeValidation(int age) {
        if (age < 0 || age > 999) {
            new Alert(Alert.AlertType.CONFIRMATION,"Invalid age. Must be a number between 0 and 999.").show();
            return false;
        }
        return true;
    }




    public boolean customerEmailValidation(String email) {
        if (!email.matches("^\\S+@\\S+$")) {

            return false;
        }
        return true;
    }


    public String btnBooknowOnAction(ActionEvent actionEvent) throws IOException {


        //String bookingId = generateBookingId(); // call a method to generate a unique booking ID
        String bookingId = txtBookingId.getText();
        String chooseBike = cmbChooseBike.getValue().toString();
        String pickUpLocation = cmbPickUpLocation.getValue().toString();
        LocalDate pickUpDate = dtpkPickUpLocation.getValue();
        String pickUpTime = cmbPickUpTime.getValue().toString();
        String dropOffLocation = cmbDropOffLocation.getValue().toString();
        LocalDate dropOffDate = dtpkDropOffLocation.getValue();
        String dropOffTime = cmbDropOffTime.getValue().toString();
        //String cid = txtCustomerId.getText();

        if (bookingIdValidation(bookingId)) {
            if (BookingModel.validateBookingId(bookingId)) {

                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentabike", "root", "1234")) {
                    String sql = "INSERT INTO Booking(bookingId, chooseBike, PickUpLocation, pickUpDate, pickUpTime, dropOffLocation, dropOffDate, dropOffTime) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";


                    PreparedStatement pstm = con.prepareStatement(sql);
                    //String bookingId = null;
                    pstm.setString(1, bookingId);
                    pstm.setString(2, chooseBike);
                    pstm.setString(3, pickUpLocation);
                    pstm.setDate(4, Date.valueOf(pickUpDate));
                    pstm.setString(5, pickUpTime);
                    pstm.setString(6, dropOffLocation);
                    pstm.setDate(7, Date.valueOf(dropOffDate));
                    pstm.setString(8, dropOffTime);
                    //pstm.setString(9, cid);
                    //pstm.setInt(9, Integer.parseInt(cid));


                    int affectedRows = pstm.executeUpdate();
                    if (affectedRows > 0) {
                        new Alert(Alert.AlertType.CONFIRMATION,
                                "Booking successfully saved!")
                                .show();
                    }
                } catch (SQLException ex) {
                    // handle exception here
                    ex.printStackTrace();
                }

            } else {
                new Alert(Alert.AlertType.WARNING, "The booking ID already exists, So use different booking Id").show();
            }
        } else {
            new Alert(Alert.AlertType.CONFIRMATION,"Invalid booking ID. Must be in the format b001, b002, b011.").show();
        }

        return bookingId;
    }

    public boolean bookingIdValidation(String bookingId) {
        if (!bookingId.matches("^b\\d{3,4}$")) {
            return false;
        }
        return true;
    }


}

    
