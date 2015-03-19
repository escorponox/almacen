package webservices.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the webservices.client package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegisterResponse_QNAME = new QName("http://webservices/", "registerResponse");
    private final static QName _RecOrder_QNAME = new QName("http://www.carlos.coves.com/jaxb", "recOrder");
    private final static QName _RecOrderResponse_QNAME = new QName("http://www.carlos.coves.com/jaxb", "recOrderResponse");
    private final static QName _Register_QNAME = new QName("http://webservices/", "register");
    private final static QName _RecLine_QNAME = new QName("http://www.carlos.coves.com/jaxb", "recLine");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservices.client
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RecOrderRequest }
     */
    public RecOrderRequest createRecOrderRequest() {
        return new RecOrderRequest();
    }

    /**
     * Create an instance of {@link RecOrderResponse }
     */
    public RecOrderResponse createRecOrderResponse() {
        return new RecOrderResponse();
    }

    /**
     * Create an instance of {@link Register }
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link RecLineResponse }
     */
    public RecLineResponse createRecLineResponse() {
        return new RecLineResponse();
    }

    /**
     * Create an instance of {@link RecLineRequest }
     */
    public RecLineRequest createRecLineRequest() {
        return new RecLineRequest();
    }

    /**
     * Create an instance of {@link RecOrderRequest.RecLines }
     */
    public RecOrderRequest.RecLines createRecOrderRequestRecLines() {
        return new RecOrderRequest.RecLines();
    }

    /**
     * Create an instance of {@link RecOrderResponse.RecLineResponses }
     */
    public RecOrderResponse.RecLineResponses createRecOrderResponseRecLineResponses() {
        return new RecOrderResponse.RecLineResponses();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecOrderRequest }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.carlos.coves.com/jaxb", name = "recOrder")
    public JAXBElement<RecOrderRequest> createRecOrder(RecOrderRequest value) {
        return new JAXBElement<RecOrderRequest>(_RecOrder_QNAME, RecOrderRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecOrderResponse }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.carlos.coves.com/jaxb", name = "recOrderResponse")
    public JAXBElement<RecOrderResponse> createRecOrderResponse(RecOrderResponse value) {
        return new JAXBElement<RecOrderResponse>(_RecOrderResponse_QNAME, RecOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.carlos.coves.com/jaxb", name = "recLine")
    public JAXBElement<Object> createRecLine(Object value) {
        return new JAXBElement<Object>(_RecLine_QNAME, Object.class, null, value);
    }

}
