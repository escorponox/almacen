<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div>
    <h2>Select Receipt</h2>
    <sf:form method="post" id="receiptSelectForm" modelAttribute="receiptSelectForm">
        <table cellspacing="5" style="text-align: center">
            <tr>
                <td><sf:label path="orderCode">Order Code: </sf:label></td>
                <td><sf:input path="orderCode" disabled="true"/></td>
                <td><sf:errors path="orderCode"/></td>
            </tr>
            <tr>
                <td><sf:label path="deliveryNote">Delivery Note: </sf:label></td>
                <td><sf:input path="deliveryNote"/></td>
                <td><sf:errors path="deliveryNote"/></td>
            </tr>
            <tr>
                <td><sf:label path="dockId">Incoming Dock: </sf:label></td>
                <td><sf:select path="dockId">
                    <sf:options items="${docks}" itemValue="id" itemLabel="name"/>
                </sf:select>
                </td>
                <td><sf:errors path="dockId"/></td>
            </tr>

            <tr>
                <td><input type="button" value="Select"
                           onclick="document.getElementById('receiptSelectForm').submit()"></td>
            </tr>
        </table>
    </sf:form>
</div>