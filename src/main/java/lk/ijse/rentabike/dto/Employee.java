package lk.ijse.rentabike.dto;

import lombok.*;



public class Employee {
    private String employeeId;
    private String employeeTyped;
    private String name;
    private String nic;
    private String address;
    private String contact;
    private String email;

    public Employee() {
    }

    public Employee(String employeeId, String employeeTyped, String name, String nic, String address, String contact, String email) {
        this.employeeId = employeeId;
        this.employeeTyped = employeeTyped;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeTyped() {
        return employeeTyped;
    }

    public void setEmployeeTyped(String employeeTyped) {
        this.employeeTyped = employeeTyped;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeTyped='" + employeeTyped + '\'' +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
