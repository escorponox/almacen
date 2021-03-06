package webservices.client;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 */
@WebServiceClient(name = "ReceivingOrdersSOAP", targetNamespace = "http://webservices/", wsdlLocation = "https://localhost:8443/almacen/ReceivingOrdersSOAP?wsdl")
public class ReceivingOrdersSOAP_Service
        extends Service {

    private final static URL RECEIVINGORDERSSOAP_WSDL_LOCATION;
    private final static WebServiceException RECEIVINGORDERSSOAP_EXCEPTION;
    private final static QName RECEIVINGORDERSSOAP_QNAME = new QName("http://webservices/", "ReceivingOrdersSOAP");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            //for localhost testing only
            javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                    new javax.net.ssl.HostnameVerifier() {

                        public boolean verify(String hostname,
                                              javax.net.ssl.SSLSession sslSession) {
                            return "localhost".equals(hostname);
                        }
                    });
            url = new URL("https://localhost:8443/almacen/ReceivingOrdersSOAP?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RECEIVINGORDERSSOAP_WSDL_LOCATION = url;
        RECEIVINGORDERSSOAP_EXCEPTION = e;
    }

    public ReceivingOrdersSOAP_Service() {
        super(__getWsdlLocation(), RECEIVINGORDERSSOAP_QNAME);
    }

    public ReceivingOrdersSOAP_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), RECEIVINGORDERSSOAP_QNAME, features);
    }

    public ReceivingOrdersSOAP_Service(URL wsdlLocation) {
        super(wsdlLocation, RECEIVINGORDERSSOAP_QNAME);
    }

    public ReceivingOrdersSOAP_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RECEIVINGORDERSSOAP_QNAME, features);
    }

    public ReceivingOrdersSOAP_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ReceivingOrdersSOAP_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (RECEIVINGORDERSSOAP_EXCEPTION != null) {
            throw RECEIVINGORDERSSOAP_EXCEPTION;
        }
        return RECEIVINGORDERSSOAP_WSDL_LOCATION;
    }

    /**
     * @return returns ReceivingOrdersSOAP
     */
    @WebEndpoint(name = "ReceivingOrdersSOAPPort")
    public ReceivingOrdersSOAP getReceivingOrdersSOAPPort() {
        return super.getPort(new QName("http://webservices/", "ReceivingOrdersSOAPPort"), ReceivingOrdersSOAP.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns ReceivingOrdersSOAP
     */
    @WebEndpoint(name = "ReceivingOrdersSOAPPort")
    public ReceivingOrdersSOAP getReceivingOrdersSOAPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices/", "ReceivingOrdersSOAPPort"), ReceivingOrdersSOAP.class, features);
    }

}
