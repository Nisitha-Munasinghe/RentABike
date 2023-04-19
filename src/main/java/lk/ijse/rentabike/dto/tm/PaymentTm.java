package lk.ijse.rentabike.dto.tm;

public class PaymentTm {
    String payId;
    Double payAmount;
    String payDescription;
    String payDate;
    String customerId;
    String bookingId;

    public PaymentTm() {
    }

    public PaymentTm(String payId, Double payAmount, String payDescription, String payDate, String customerId, String bookingId) {
        this.payId = payId;
        this.payAmount = payAmount;
        this.payDescription = payDescription;
        this.payDate = payDate;
        this.customerId = customerId;
        this.bookingId = bookingId;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayDescription() {
        return payDescription;
    }

    public void setPayDescription(String payDescription) {
        this.payDescription = payDescription;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "PaymentTm{" +
                "payId='" + payId + '\'' +
                ", payAmount=" + payAmount +
                ", payDescription='" + payDescription + '\'' +
                ", payDate='" + payDate + '\'' +
                ", customerId='" + customerId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                '}';
    }
}
