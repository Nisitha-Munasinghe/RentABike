package lk.ijse.rentabike.dto;

public class Payment {
    String payId;
    Double payAmount;
    String payDescription;
    String payDate;
    String cId;
    String bId;

    public Payment() {
    }

    public Payment(String payId, Double payAmount, String payDescription, String payDate, String cId, String bId) {
        this.payId = payId;
        this.payAmount = payAmount;
        this.payDescription = payDescription;
        this.payDate = payDate;
        this.cId = cId;
        this.bId = bId;
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

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payId='" + payId + '\'' +
                ", payAmount=" + payAmount +
                ", payDescription='" + payDescription + '\'' +
                ", payDate='" + payDate + '\'' +
                ", cId='" + cId + '\'' +
                ", bId='" + bId + '\'' +
                '}';
    }
}
