<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <h2>Order: </h2>
    <sf:form method="post" modelAttribute="order">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

        <h3>Customer: </h3>
        <table cellspacing="3">
            <tr>
                <td>NIF:</td>
                <td><c:out value="${order.customer.nif}"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><c:out value="${order.customer.name}"/></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><c:out value="${order.customer.address}"/></td>
            </tr>
        </table>
        <h3>Lines: </h3>
        <table cellspacing="5" style="text-align: center">
            <tr>
                <th></th>
                <th>Code</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Unit Price</th>
                <th>Price</th>
            </tr>
            <tbody style="border: #31708f">
            <c:forEach items="${order.orderLines}" var="line">
                <tr>
                    <td><c:out value="${line.lineNumber.toString()}"/></td>
                    <td><c:out value="${line.item.code}"/></td>
                    <td><c:out value="${line.item.name}"/></td>
                    <td><c:out value="${line.orderedQuantity}"/></td>
                    <td><c:out value="${line.item.price}"/></td>
                    <td><c:out value="${line.orderedQuantity * line.item.price}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table>
            <tr>
                <td>Total:</td>
                <td><c:out value="${order.totalAmount}"/> &euro;</td>
            </tr>
        </table>
        <table>
            <tr>
                <td>
                    <input type="submit" name="_eventId_newLine" value="New Line"/>
                </td>
                <td>
                    <input type="submit" name="_eventId_checkOut" value="Check Out"/>
                </td>
                <td>
                    <input type="submit" name="_eventId_cancel" value="Cancel"/>
                </td>
            </tr>
        </table>

    </sf:form>
</div>