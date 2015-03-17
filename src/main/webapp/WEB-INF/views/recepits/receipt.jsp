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
    <sf:form method="post" id="receiptForm" action="${pageContext.request.contextPath}/receipt/create"
             modelAttribute="receiptForm">
        <div>
            <sf:errors/>
        </div>
        <table cellspacing="5" style="text-align: center">
            <tr>
                <td><sf:label path="orderCode">Order Code: </sf:label>
                    <sf:input path="orderCode" readonly="true" tabindex="-1"/>
                </td>
                <td><sf:label path="deliveryNote">Delivery Note: </sf:label>
                    <sf:input path="deliveryNote" readonly="true" tabindex="-1"/>
                </td>
                <td>
                    <sf:label path="dockName">Incoming Dock: </sf:label>
                    <sf:input path="dockName" readonly="true" tabindex="-1"/>
                    <sf:hidden path="dockId"/>
                </td>
            </tr>
            <tr>
                <td><sf:label path="providerCode">Provider Code: </sf:label>
                    <sf:input path="providerCode" readonly="true" tabindex="-1"/></td>
                <td><sf:label path="providerName">Provider Code: </sf:label>
                    <sf:input path="providerName" readonly="true" tabindex="-1"/></td>
            </tr>
        </table>
        <table cellspacing="5" style="text-align: center">
            <tr>
                <th>Line</th>
                <th>Item Code</th>
                <th>Item Name</th>
                <th>Pending Quantity</th>
                <th>Received Quantity</th>
                <th></th>
            </tr>
            <c:forEach items="${receiptForm.receiptActionsForms}" var="recAction" varStatus="status">
                <tr>
                    <td align="center"><input type="hidden"
                                              name="receiptActionsForms[${status.index}].receivingOrderLine"
                                              value="${recAction.receivingOrderLine}">${status.count}</td>
                    <td align="center"><input name="receiptActionsForms[${status.index}].itemCode"
                                              value="${recAction.itemCode}" readonly="true" tabindex="-1"></td>
                    <td align="center"><input name="receiptActionsForms[${status.index}].itemName"
                                              value="${recAction.itemName}" readonly="true" tabindex="-1"></td>
                    <td align="center"><input name="receiptActionsForms[${status.index}].pendingQuantity"
                                              value="${recAction.pendingQuantity}" readonly="true" tabindex="-1"></td>
                    <td align="center"><input name="receiptActionsForms[${status.index}].recQuantity"
                                              value="${recAction.recQuantity}"></td>
                    <td><sf:errors path="receiptActionsForms[${status.index}].recQuantity"/></td>
                </tr>
            </c:forEach>
            <tr>
                <td><input type="button" value="Create"
                           onclick="document.getElementById('receiptForm').submit()"></td>
            </tr>
        </table>
    </sf:form>
</div>