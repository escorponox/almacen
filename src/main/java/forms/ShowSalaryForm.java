package forms;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ShowSalaryForm {

    private String month;
    private BigDecimal commission;
    private List<SalaryOrder> salaryOrders;
    private BigDecimal totalSalary;

    public ShowSalaryForm() {
        salaryOrders = new LinkedList<>();
        totalSalary = BigDecimal.ZERO;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public List<SalaryOrder> getSalaryOrders() {
        return salaryOrders;
    }

    public void setSalaryOrders(List<SalaryOrder> salaryOrders) {
        this.salaryOrders = salaryOrders;
    }

    public BigDecimal getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(BigDecimal totalSalary) {
        this.totalSalary = totalSalary;
    }
}
