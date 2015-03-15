package webservices.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "recOrder", namespace = "http://www.carlos.coves.com/jaxb")
@XmlType(propOrder = {"orderCode", "providerNif", "recLines"})
public class RecOrderRequest {

    private Long orderCode;
    private String providerNif;
    private List<RecLineRequest> recLines;

    public RecOrderRequest() {
        recLines = new LinkedList<>();
    }

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    public String getProviderNif() {
        return providerNif;
    }

    public void setProviderNif(String providerNif) {
        this.providerNif = providerNif;
    }

    public List<RecLineRequest> getRecLines() {
        return recLines;
    }

    @XmlElementWrapper(name = "recLines")
    @XmlElement(name = "recLine")
    public void setRecLines(List<RecLineRequest> recLines) {
        this.recLines = recLines;
    }
}
