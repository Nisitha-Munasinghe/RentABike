package lk.ijse.rentabike.dto;


import lombok.*;

import java.sql.Date;



public class Booking {
    private String bookingId;
    private String chooseBike;
    private String pickUpLocation;
    private String pickUpDate;
    private String pickUpTime;
    private String dropOffLocation;
    private String dropOffDate;
    private String dropOffTime;

    public Booking() {
    }

    public Booking(String bookingId, String chooseBike, String pickUpLocation, String pickUpDate, String pickUpTime, String dropOffLocation, String dropOffDate, String dropOffTime) {
        this.bookingId = bookingId;
        this.chooseBike = chooseBike;
        this.pickUpLocation = pickUpLocation;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.dropOffLocation = dropOffLocation;
        this.dropOffDate = dropOffDate;
        this.dropOffTime = dropOffTime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getChooseBike() {
        return chooseBike;
    }

    public void setChooseBike(String chooseBike) {
        this.chooseBike = chooseBike;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public String getDropOffTime() {
        return dropOffTime;
    }

    public void setDropOffTime(String dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", chooseBike='" + chooseBike + '\'' +
                ", pickUpLocation='" + pickUpLocation + '\'' +
                ", pickUpDate='" + pickUpDate + '\'' +
                ", pickUpTime='" + pickUpTime + '\'' +
                ", dropOffLocation='" + dropOffLocation + '\'' +
                ", dropOffDate='" + dropOffDate + '\'' +
                ", dropOffTime='" + dropOffTime + '\'' +
                '}';
    }
}
