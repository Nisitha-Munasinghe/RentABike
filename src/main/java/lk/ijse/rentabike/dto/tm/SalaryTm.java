package lk.ijse.rentabike.dto.tm;

public class SalaryTm {
    private String salaryId;
    private String description;
    private double amount;
    private String type;

    public SalaryTm() {
    }

    public SalaryTm(String salaryId, String description, double amount, String type) {
        this.salaryId = salaryId;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SalaryTm{" +
                "salaryId='" + salaryId + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
