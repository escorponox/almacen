package webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import services.ReceivingOrderService;
import webservices.domain.RecOrderRequest;
import webservices.domain.RecOrderResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@Component
@WebService(serviceName = "ReceivingOrdersSOAP")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class ReceivingOrdersSOAP extends SpringBeanAutowiringSupport {

    @Autowired
    private ReceivingOrderService receivingOrderService;

    @WebMethod(operationName = "register")
    public RecOrderResponse request(@WebParam(name = "request") RecOrderRequest recOrderRequest) {

        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        RecOrderResponse recOrderResponse = new RecOrderResponse();

        receivingOrderService.processRequest(recOrderRequest, recOrderResponse);

        return recOrderResponse;
    }
}
