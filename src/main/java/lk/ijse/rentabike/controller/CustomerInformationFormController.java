package lk.ijse.rentabike.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.rentabike.dto.Customer;
import lk.ijse.rentabike.model.CustomerModel;

import java.sql.SQLException;

public class CustomerInformationFormController {
    public TextField txtCustomerId;
    public TextField txtFullname;
    public TextField txtAge;
    public TextField txtPhoneNumber;
    public TextField txtEmail;
    public TextField txtAddress;
    public TextField txtCity;
    public TextField txtCountry;
    public TextField txtZipcode;


    public void BookingIdSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String CustomerId = txtCustomerId.getText();
        String Fullname = txtFullname.getText();
        int Age = Integer.parseInt(txtAge.getText());
        String PhoneNumber = txtPhoneNumber.getText();
        String Email = txtEmail.getText();
        String Address = txtAddress.getText();
        String City = txtCity.getText();
        String Country = txtCountry.getText();
        String Zipcode = txtZipcode.getText();


        Customer custo = new Customer(CustomerId, Fullname, Age, PhoneNumber, Email, Address, City, Country, Zipcode);

       try {
//            boolean isSaved = ItemModel.save(code, description, unitPrice, qtyOnHand);
            boolean isSaved = CustomerModel.save(custo);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String CustomerId = txtCustomerId.getText();
        try {
            boolean isDeleted = CustomerModel.delete(CustomerId);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }
    }

    public void CustomerIdSearchOnAction(ActionEvent actionEvent) {
        try {
            Customer customer = CustomerModel.search(txtCustomerId.getText());
            if (customer != null) {
                txtCustomerId.setText(customer.getCustomerId());
                txtFullname.setText(customer.getFullName());
                txtAge.setText(String.valueOf(customer.getAge()));
                txtPhoneNumber.setText(String.valueOf(customer.getPhoneNumber()));
                txtEmail.setText(customer.getEmail());
                txtAddress.setText(customer.getAddress());
                txtCity.setText(customer.getCity());
                txtCountry.setText(customer.getCountry());
                txtZipcode.setText(customer.getZipCode());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "something happened!").show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String CustomerId = txtCustomerId.getText();
        String Fullname = txtFullname.getText();
        int Age = Integer.parseInt(txtAge.getText());
        String PhoneNumber = txtPhoneNumber.getText();
        String Email = txtEmail.getText();
        String Address = txtAddress.getText();
        String City = txtCity.getText();
        String Country = txtCountry.getText();
        String Zipcode = txtZipcode.getText();

        try {
            boolean isUpdated = CustomerModel.update(CustomerId, Fullname, Age, PhoneNumber, Email, Address, City, Country, Zipcode);
            new Alert(Alert.AlertType.CONFIRMATION, "Customer updated!").show();
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }
    }
}
