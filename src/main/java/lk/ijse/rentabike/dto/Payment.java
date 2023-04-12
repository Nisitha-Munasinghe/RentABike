package lk.ijse.rentabike.dto;

public class Payment {
    String payId;
    Double payAmount;
    String payDescription;
    String payDate;

    public Payment() {
    }

    public Payment(String payId, Double payAmount, String payDescription, String payDate) {
        this.payId = payId;
        this.payAmount = payAmount;
        this.payDescription = payDescription;
        this.payDate = payDate;
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

    @Override
    public String toString() {
        return "Payment{" +
                "payId='" + payId + '\'' +
                ", payAmount=" + payAmount +
                ", payDescription='" + payDescription + '\'' +
                ", payDate='" + payDate + '\'' +
                '}';
    }
}
