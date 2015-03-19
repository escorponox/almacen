package services.domain;

import java.math.BigDecimal;

public class FillItemDataResponse {

    private String errorCode;
    private String errorDescription;
    private ResponseData data = new ResponseData();

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }

    public class ResponseData {

        private String itemName;
        private BigDecimal itemPrice;

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public BigDecimal getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(BigDecimal itemPrice) {
            this.itemPrice = itemPrice;
        }
    }
}
