<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div>
    <h2>Entities List</h2>
    <table cellspacing="5">
        <tr>
            <th>Titulo</th>
            <th>Numero</th>
            <th>aaa</th>
        </tr>
        <c:forEach items="${userList}" var="item">
            <tr>
                <td><c:out value="${item.username}"/></td>
                <td><c:out value="${item.commission}"/></td>
                <td>
                    <sf:checkboxes path="item.userRoleById" items="rols">
                        rols
                    </sf:checkboxes>
                    <c:out value="${item.userRoleById}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>