package forms;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SelectMonthForm {

    @NotNull(message = "Please select month")
    @Range(min = 1, max = 12, message = "Month out of range")
    private Integer month;

    @NotNull(message = "Please select year")
    @Min(value = 2015, message = "Year out of range")
    private Integer year;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
