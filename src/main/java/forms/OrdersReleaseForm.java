package forms;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

public class OrdersReleaseForm {

    @Valid
    @NotNull
    private List<OrderRelease> orderReleases;

    public OrdersReleaseForm() {

        orderReleases = new LinkedList<>();
    }

    public List<OrderRelease> getOrderReleases() {
        return orderReleases;
    }

    public void setOrderReleases(List<OrderRelease> orderReleases) {
        this.orderReleases = orderReleases;
    }
}
