<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<style>
    span[id$=".errors"] {
        color: #e30002;
    }
</style>
<div>
    <h2>Your Locate Action</h2>
    <sf:form method="post" id="locateActionForm" action="${pageContext.request.contextPath}/locate/confirm"
             modelAttribute="locateActionForm">
        <table cellspacing="5" style="text-align: center">
            <tr>
                <td><sf:hidden path="locateActionId"/>
                    <sf:label path="dockName">Dock: </sf:label></td>
                <td><sf:input path="dockName" readonly="true" tabindex="-1"/></td>
                <td></td>
            </tr>
            <tr>
                <td><sf:label path="itemCode">Item Code: </sf:label></td>
                <td><sf:input path="itemCode" readonly="true" tabindex="-1"/></td>
                <td></td>
            </tr>
            <tr>
                <td><sf:label path="itemName">Item Name: </sf:label></td>
                <td><sf:input path="itemName" readonly="true" tabindex="-1"/></td>
                <td></td>
            </tr>
            <tr>
                <td><sf:label path="quantity">Quantity: </sf:label></td>
                <td><sf:input path="quantity" readonly="true" tabindex="-1"/></td>
                <td></td>
            </tr>
            <tr>
                <td><sf:label path="destination">Destination: </sf:label></td>
                <td><sf:input path="destination" readonly="true" tabindex="-1"/></td>
                <td></td>
            </tr>
            <tr>
                <td><sf:label path="locationConfirmation">Confirmation: </sf:label></td>
                <td><sf:input path="locationConfirmation"/></td>
                <td><sf:errors path="locationConfirmation"/></td>
            </tr>
            <tr>
                <td><input type="button" value="Confirm" onclick="document.getElementById('receiptForm').submit()"/>
                </td>
            </tr>
        </table>

    </sf:form>
</div>