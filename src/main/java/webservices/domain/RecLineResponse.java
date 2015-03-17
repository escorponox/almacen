package webservices.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "recLine", namespace = "http://www.carlos.coves.com/jaxb")
@XmlType(propOrder = {"responseCode", "errorDescription"})
public class RecLineResponse {

    private String responseCode;
    private String errorDescription;

    public RecLineResponse() {
        responseCode = "0";
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
