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
    <sf:form method="post" id="ordersReleaseForm" action="${pageContext.request.contextPath}/release/release"
             modelAttribute="ordersReleaseForm">
        <div>
            <sf:errors/>
        </div>
        <table cellspacing="5" style="text-align: center">
            <tr>
                <th></th>
                <th>Order Code</th>
                <th>Customer</th>
                <th>Status</th>
                <th>Release</th>
                <th>Dock</th>
            </tr>
            <c:forEach items="${ordersReleaseForm.orderReleases}" var="releaseCandidate" varStatus="status">
                <tr>
                    <td align="center"><input type="hidden"
                                              name="orderReleases[${status.index}].orderId"
                                              value="${releaseCandidate.orderId}">${status.count}</td>
                    <td align="center"><input name="orderReleases[${status.index}].orderCode"
                                              value="${releaseCandidate.orderCode}" readonly="true" tabindex="-1"></td>
                    <td align="center"><input name="orderReleases[${status.index}].customerName"
                                              value="${releaseCandidate.customerName}" readonly="true" tabindex="-1">
                    </td>
                    <td align="center"><input name="orderReleases[${status.index}].ordersStatusEnum"
                                              value="${releaseCandidate.ordersStatusEnum}" readonly="true"
                                              tabindex="-1"></td>
                    <td align="center"><input type="checkbox" name="orderReleases[${status.index}].released"
                                              value="1" <c:if test="${releaseCandidate.released}">checked</c:if>/></td>
                    <td align="center">
                        <select name="orderReleases[${status.index}].dockId">
                            <c:forEach items="${docks}" var="dock">
                                <option value="<c:out value="${dock.id}"/>"><c:out value="${dock.name}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><input type="button" value="Release"
                           onclick="document.getElementById('ordersReleaseForm').submit()"></td>
            </tr>
        </table>
    </sf:form>
</div>