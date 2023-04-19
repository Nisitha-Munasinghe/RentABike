package lk.ijse.rentabike.dto;

public class Salary {
    private String salaryId;
    private String description;
    private Double amount;
    private String type;
    private String month;
    private String employeeId;

    public Salary() {
    }

    public Salary(String salaryId, String description, Double amount, String type, String month, String employeeId) {
        this.salaryId = salaryId;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.month = month;
        this.employeeId = employeeId;
    }

    public Salary(String salaryId, String description, double amount, String type, String employeeId) {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryId='" + salaryId + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", month='" + month + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
