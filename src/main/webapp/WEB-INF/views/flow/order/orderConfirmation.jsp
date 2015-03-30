<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <h2>Order</h2>
    <sf:form method="post" modelAttribute="order">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

        <h3>Customer</h3>
        <table class="table table-bordered table-striped">
            <tr>
                <td>NIF</td>
                <td><c:out value="${order.customer.nif}"/></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><c:out value="${order.customer.name}"/></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><c:out value="${order.customer.address}"/></td>
            </tr>
        </table>
        <h3>Lines</h3>

        <div class="table-responsive">
            <table class="table table-bordered table-striped table-hover table-condensed">
                <tr>
                    <th>#</th>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Unit Price</th>
                    <th>Price</th>
                </tr>
                <tbody>
                <c:forEach items="${order.orderLines}" var="line">
                    <tr>
                        <td><c:out value="${line.lineNumber.toString()}"/></td>
                        <td><c:out value="${line.item.code}"/></td>
                        <td><c:out value="${line.item.name}"/></td>
                        <td><c:out value="${line.orderedQuantity}"/></td>
                        <td><c:out value="${line.item.price}"/> &euro;</td>
                        <td><c:out value="${line.orderedQuantity * line.item.price}"/> &euro;</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="4"/>
                    <td>Total:</td>
                    <td><c:out value="${order.totalAmount}"/> &euro;</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div>
            <button class="btn btn-default" type="submit" name="_eventId_orderConfirm">Confirm</button>
            <button class="btn btn-default" type="submit" name="_eventId_cancelConfirm">Cancel</button>
        </div>

    </sf:form>
</div>