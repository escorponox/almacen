package forms;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SelectMonthForm {

    @NotNull(message = "Please select month")
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date month;

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }
}
