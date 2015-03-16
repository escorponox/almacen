package forms;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

public class ReceiptForm {

    @NotNull
    private Long orderCode;

    @NotNull
    private String deliveryNote;

    @NotNull
    private Long dockId;


    private List<Integer> quantities;

    public ReceiptForm() {
        quantities = new LinkedList<>();
    }
}
