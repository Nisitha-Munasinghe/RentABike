package lk.ijse.rentabike.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.rentabike.dto.Attendence;
import lk.ijse.rentabike.dto.tm.AttendenceTm;
import lk.ijse.rentabike.model.AttendenceModel;
import lk.ijse.rentabike.model.CustomerModel;
import net.sf.jasperreports.engine.design.JasperDesign;

import java.sql.*;
import java.time.LocalDate;
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

    public ComboBox cmbHoliday;

    public TextField txtEmployeedId;
    public TextField txtDaystatus;

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
    private TableView<AttendenceTm> tblAttendenceManagement;

    @FXML
    private TextField txtAttendenceId;


    @FXML
    private TextField txtSignInTime;

    @FXML
    private TextField txtSignOutTime;

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        ObservableList<String> dayStatusList = FXCollections.observableArrayList();
        dayStatusList.add("workday");
        dayStatusList.add("holiday");

        cmbHoliday.setItems(dayStatusList);


        setCellValueFactory();
        getAll();
    }

    private void setCellValueFactory() {
        colAttendencedId.setCellValueFactory(new PropertyValueFactory<>("attendenceId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("attendencedate"));
        colHoliday.setCellValueFactory(new PropertyValueFactory<>("holidayOrWorkedday"));
        colSignInTime.setCellValueFactory(new PropertyValueFactory<>("attendenceSignInTime"));
        colSignOutTime.setCellValueFactory(new PropertyValueFactory<>("attendenceSignOutTime"));
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
    }

    private void getAll() {
        try {
            ObservableList<AttendenceTm> obList = FXCollections.observableArrayList();
            List<Attendence> attenList = AttendenceModel.getAll();

            for (Attendence attendence : attenList) {
                obList.add(new AttendenceTm(
                        attendence.getAttendenceId(),
                        attendence.getAttendencedate(),
                        attendence.getHolidayOrWorkedday(),
                        attendence.getAttendenceSignInTime(),
                        attendence.getAttendenceSignOutTime(),
                        attendence.getEmployeeId()
                ));
            }
            tblAttendenceManagement.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }




    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException {
        String AttendenceId = txtAttendenceId.getText();
        LocalDate date = dtpkDate.getValue();
        String Holiday = cmbHoliday.getValue().toString();
        String SignInTime = txtSignInTime.getText();
        String SignOutTime = txtSignOutTime.getText();
        String EmployeedId = txtEmployeedId.getText();


        if (attendenceIdFormatValidation(AttendenceId)) {
            if (AttendenceModel.validateAttendenceId(AttendenceId)) {
                if (timeValidation(SignInTime)) {

                    try (Connection con = DriverManager.getConnection(URL, props)) {
                        String sql = "INSERT INTO Attendance(attendenceId, date, holiday, signInTime, signOutTime, employeeId)" +
                                "VALUES(?, ?, ?, ?, ?, ?)";
                        PreparedStatement pstm = con.prepareStatement(sql);
                        pstm.setString(1, AttendenceId);
                        pstm.setDate(2, Date.valueOf(date));
                        pstm.setString(3, Holiday);
                        pstm.setString(4, SignInTime);
                        pstm.setString(5, SignOutTime);
                        pstm.setString(6, EmployeedId);

                        int affectedRows = pstm.executeUpdate();
                        if (affectedRows > 0) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "attendence added :)")
                                    .show();
                        }
                    }

                } else {
                    new Alert(Alert.AlertType.WARNING,"Invalid time. Must be in the format HH:mm:ss.").show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "The Attendence ID already exists, So use different Attendence Id").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING,"Invalid attendance ID. Must be in the format at001, at002, at012.").show();
        }
    }

    public boolean timeValidation(String time) {
        String regex = "([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d";
        if (!time.matches(regex)) {
            return false;
        }
        return true;
    }


    public boolean attendenceIdFormatValidation(String AttendenceId) {
        if (!AttendenceId.matches("^at\\d{3}$")) {
            return false;
        }
        return true;
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException {
        String AttendenceId = txtAttendenceId.getText();
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "DELETE FROM Attendance WHERE AttendenceId = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, AttendenceId);

            if (pstm.executeUpdate() > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "deleted!").show();
            }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException {
        String AttendenceId = txtAttendenceId.getText();
        LocalDate date = dtpkDate.getValue();
        String Holiday = cmbHoliday.getValue().toString();
        String SignInTime = txtSignInTime.getText();
        String SignOutTime = txtSignOutTime.getText();
        String EmployeedId = txtEmployeedId.getText();



        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "UPDATE Attendance SET date = ?, holiday = ?, signInTime = ?, signOutTime = ?, employeeId = ? WHERE attendenceId = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setDate(1, Date.valueOf(date));
            pstm.setString(2, Holiday);
            pstm.setString(3, SignInTime);
            pstm.setString(4, SignOutTime);
            pstm.setString(5, EmployeedId);
            pstm.setString(6, AttendenceId);

            boolean isUpdated = pstm.executeUpdate() > 0;
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "updated!!").show();
            }
        }
    }

    public void codeSearchOnAction(ActionEvent actionEvent) throws SQLException {
        String AttendenceId = txtAttendenceId.getText();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "SELECT * FROM Attendance WHERE attendenceId = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, AttendenceId);

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                String atten_AttendenceId = resultSet.getString(1);
                String atten_date = String.valueOf(resultSet.getDate(2));
                String atten_Holiday = resultSet.getString(3);
                String atten_SignInTime = resultSet.getString(3);
                String atten_SignOutTime = resultSet.getString(3);
                String atten_EmployeedId = resultSet.getString(3);

                txtAttendenceId.setText(atten_AttendenceId);
                dtpkDate.setValue(LocalDate.parse(atten_date));
                //cmbHoliday.setValue((atten_Holiday));
                txtSignInTime.setText(atten_SignInTime);
                txtSignOutTime.setText(atten_SignOutTime);
                txtEmployeedId.setText(atten_EmployeedId);
            }
        }
    }
}
