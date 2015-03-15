
package webservices.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recOrderRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recOrderRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="providerNif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recLines" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="recLine" type="{http://webservices/}recLineRequest" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recOrderRequest", propOrder = {
    "orderCode",
    "providerNif",
    "recLines"
})
public class RecOrderRequest {

    protected Long orderCode;
    protected String providerNif;
    protected RecOrderRequest.RecLines recLines;

    /**
     * Gets the value of the orderCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrderCode() {
        return orderCode;
    }

    /**
     * Sets the value of the orderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrderCode(Long value) {
        this.orderCode = value;
    }

    /**
     * Gets the value of the providerNif property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderNif() {
        return providerNif;
    }

    /**
     * Sets the value of the providerNif property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderNif(String value) {
        this.providerNif = value;
    }

    /**
     * Gets the value of the recLines property.
     * 
     * @return
     *     possible object is
     *     {@link RecOrderRequest.RecLines }
     *     
     */
    public RecOrderRequest.RecLines getRecLines() {
        return recLines;
    }

    /**
     * Sets the value of the recLines property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecOrderRequest.RecLines }
     *     
     */
    public void setRecLines(RecOrderRequest.RecLines value) {
        this.recLines = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="recLine" type="{http://webservices/}recLineRequest" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "recLine"
    })
    public static class RecLines {

        protected List<RecLineRequest> recLine;

        /**
         * Gets the value of the recLine property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the recLine property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRecLine().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RecLineRequest }
         * 
         * 
         */
        public List<RecLineRequest> getRecLine() {
            if (recLine == null) {
                recLine = new ArrayList<RecLineRequest>();
            }
            return this.recLine;
        }

    }

}
