package lk.ijse.rentabike.dto;

public class Salary {
    private String salaryId;
    private String description;
    private double amount;
    private String type;

    public Salary() {
    }

    public Salary(String salaryId, String description, double amount, String type) {
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
        return "Salary{" +
                "salaryId='" + salaryId + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
