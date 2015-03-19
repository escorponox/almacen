package webservices.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for recOrderResponse complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="recOrderResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recLineResponses" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="recLineResponse" type="{http://webservices/}recLineResponse" maxOccurs="unbounded" minOccurs="0"/>
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recOrderResponse", propOrder = {
        "responseCode",
        "errorDescription",
        "recLineResponses"
})
public class RecOrderResponse {

    protected String responseCode;
    protected String errorDescription;
    protected RecOrderResponse.RecLineResponses recLineResponses;

    /**
     * Gets the value of the responseCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the errorDescription property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getErrorDescription() {
        return errorDescription;
    }

    /**
     * Sets the value of the errorDescription property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setErrorDescription(String value) {
        this.errorDescription = value;
    }

    /**
     * Gets the value of the recLineResponses property.
     *
     * @return possible object is
     * {@link RecOrderResponse.RecLineResponses }
     */
    public RecOrderResponse.RecLineResponses getRecLineResponses() {
        return recLineResponses;
    }

    /**
     * Sets the value of the recLineResponses property.
     *
     * @param value allowed object is
     *              {@link RecOrderResponse.RecLineResponses }
     */
    public void setRecLineResponses(RecOrderResponse.RecLineResponses value) {
        this.recLineResponses = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p/>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p/>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="recLineResponse" type="{http://webservices/}recLineResponse" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "recLineResponse"
    })
    public static class RecLineResponses {

        protected List<RecLineResponse> recLineResponse;

        /**
         * Gets the value of the recLineResponse property.
         * <p/>
         * <p/>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the recLineResponse property.
         * <p/>
         * <p/>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRecLineResponse().add(newItem);
         * </pre>
         * <p/>
         * <p/>
         * <p/>
         * Objects of the following type(s) are allowed in the list
         * {@link RecLineResponse }
         */
        public List<RecLineResponse> getRecLineResponse() {
            if (recLineResponse == null) {
                recLineResponse = new ArrayList<RecLineResponse>();
            }
            return this.recLineResponse;
        }

    }
}
