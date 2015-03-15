package webservices.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "recOrderResponse", namespace = "http://www.carlos.coves.com/jaxb")
@XmlType(propOrder = {"responseCode", "errorDescription", "recLineResponses"})
public class RecOrderResponse {

    private String responseCode;
    private String errorDescription;
    private List<RecLineResponse> recLineResponses;

    public RecOrderResponse() {
        recLineResponses = new LinkedList<>();
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public List<RecLineResponse> getRecLineResponses() {
        return recLineResponses;
    }

    @XmlElementWrapper(name = "recLineResponses")
    @XmlElement(name = "recLineResponse")
    public void setRecLineResponses(List<RecLineResponse> recLineResponses) {
        this.recLineResponses = recLineResponses;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
