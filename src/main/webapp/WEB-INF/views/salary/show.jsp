<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <h2>Salary</h2>
    <table class="table table-bordered table-striped">
        <tr>
            <td>Month</td>
            <td><c:out value="${showSalaryForm.month}"/></td>
        </tr>
        <tr>
            <td>Commission</td>
            <td><c:out value="${showSalaryForm.commission * 100}"/>%</td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><c:out value="${showSalaryForm.totalSalary}"/> &euro;</td>
        </tr>
    </table>

    <h3>Orders</h3>

    <div class="table-responsive">
        <table class="table table-bordered table-striped table-hover table-condensed">
            <tr>
                <th>Code</th>
                <th>Order Total</th>
                <th>Order Commission</th>
            </tr>
            <tbody>
            <c:forEach items="${showSalaryForm.salaryOrders}" var="order">
                <tr>
                    <td><c:out value="${order.orderCode}"/></td>
                    <td><c:out value="${order.orderTotal}"/> &euro;</td>
                    <td><c:out value="${order.orderCommission}"/> &euro;</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>