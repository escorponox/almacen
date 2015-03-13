<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div>
    <h2>Users List</h2>
    <sf:form method="post" id="userListForm">
        <table cellspacing="5" style="text-align: center">
            <tr>
                <th>Username</th>
                <th>Enabled</th>
                <th>Commision</th>
                <th>Roles</th>
                <th>Actions</th>
                <th></th>
            </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td><c:out value="${user.username}"/></td>
                    <td><c:if test="${user.enabled}">Enabled</c:if></td>
                    <td><c:out value="${user.commission * 100}"/>%</td>
                    <td>
                        <c:forEach items="${user.userRoleById}" var="rol" varStatus="rolStatus">
                            <c:out value="${rol.role.role}"/>
                            <c:if test="${!rolStatus.last}">&nbsp;-&nbsp;</c:if>
                        </c:forEach>
                    </td>
                    <td><input type="button" value="Edit" onclick="editUser(<c:out value="${user.id}"/>)">
                        <input type="button" value="Delete" onclick="deleteUser(<c:out value="${user.id}"/>)">
                        <input type="button" value="Change Password"
                               onclick="changePassword(<c:out value="${user.id}"/>)">
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><input type="button" value="New User"
                           onclick="newUser()"></td>
            </tr>
        </table>
    </sf:form>
</div>

<script>
    function editUser(userId) {
        window.location.href = '<s:url value="/users?edit="/>' + userId;
    }
    function deleteUser(userId) {
        window.location.href = '<s:url value="/users?delete="/>' + userId;
    }
    function changePassword(userId) {
        window.location.href = '<s:url value="/users?pass="/>' + userId;
    }
    function newUser() {
        window.location.href = '<s:url value="/users?newUser"/>';
    }
</script>