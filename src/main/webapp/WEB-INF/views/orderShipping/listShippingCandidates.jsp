<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<style>
    span[id$=".errors"] {
        color: #e30002;
    }
</style>
<div>
    <h2>Receipt</h2>
    <sf:form method="post" id="ordersShippingForm" action="${pageContext.request.contextPath}/ship/ship"
             modelAttribute="ordersShippingForm">
        <div>
            <sf:errors/>
        </div>
        <div class="table-responsive">
            <table class="table table-striped">
                <tr>
                    <th></th>
                    <th>Order Code</th>
                    <th>Customer</th>
                    <th>Status</th>
                    <th>Ship</th>
                    <th>Dock</th>
                    <th></th>
                </tr>
                <c:forEach items="${ordersShippingForm.orderShippings}" var="shippingCandidates" varStatus="status">
                    <tr>
                        <td><input type="hidden"
                                   name="orderShippings[${status.index}].orderId"
                                   value="${shippingCandidates.orderId}">${status.count}</td>
                        <td><input name="orderShippings[${status.index}].orderCode"
                                   value="${shippingCandidates.orderCode}" readonly="true" tabindex="-1"></td>
                        <td><input name="orderShippings[${status.index}].customerName"
                                   value="${shippingCandidates.customerName}" readonly="true" tabindex="-1">
                        </td>
                        <td><input name="orderShippings[${status.index}].ordersStatusEnum"
                                   value="${shippingCandidates.ordersStatusEnum}" readonly="true"
                                   tabindex="-1"></td>
                        <td><input type="checkbox" name="orderShippings[${status.index}].shipped"
                                   value="1" <c:if test="${shippingCandidates.shipped}">checked</c:if>/></td>
                        <td>
                            <input name="orderShippings[${status.index}].dockName"
                                   value="${shippingCandidates.dockName}" readonly="true"
                                   tabindex="-1">
                        </td>
                        <td>
                            <sf:errors path="orderShippings[${status.index}].orderId"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="button" value="Ship"
                   onclick="document.getElementById('ordersShippingForm').submit()">


        </div>
    </sf:form>
</div>