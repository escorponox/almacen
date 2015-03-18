package services.utils.orders;

import org.springframework.stereotype.Component;

@Component
public class QuantityChecker {

    public Long check(Long quantity) throws NegativeQuantityException {
        if (quantity > 0) {
            return quantity;
        } else {
            throw new NegativeQuantityException("Negative quantity");
        }
    }
}
