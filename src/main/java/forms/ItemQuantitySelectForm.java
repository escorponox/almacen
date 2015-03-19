package forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ItemQuantitySelectForm implements Serializable {

    private static final long serialVersionUID = -2244305746125967333L;

    @NotEmpty(message = "Please insert code.")
    private String code;
    private String name;
    private BigDecimal price;

    @NotNull(message = "Please insert quantity.")
    @Min(value = 1, message = "You must order at least a unit.")
    private Long quantity;
    private BigDecimal lineAmount;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(BigDecimal lineAmount) {
        this.lineAmount = lineAmount;
    }
}
