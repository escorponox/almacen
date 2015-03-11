<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div>
    <h2>Edit User</h2>
    <sf:form method="post" id="userForm" modelAttribute="user">
        <table cellspacing="5" style="text-align: center">
            <tr>
                <sf:hidden path="id"/>
                <td><sf:label path="username">User: </sf:label></td>
                <td><sf:input path="username"/></td>
                <td><sf:errors path="username"/></td>
            </tr>
            <tr>
                <td><sf:label path="enabled">Enabled: </sf:label></td>
                <td><sf:checkbox path="enabled"/></td>
                <td><sf:errors path="enabled"/></td>
            </tr>
            <tr>
                <td><sf:label path="commission">Commission: </sf:label></td>
                <td><sf:input path="commission"/></td>
                <td><sf:errors path="commission"/></td>
            </tr>
            <tr>
                <td><sf:label path="roleTypes">Roles: </sf:label></td>
                <td><sf:checkboxes path="roleTypes" items="${roleTypesList}"/></td>
                <td><sf:errors path="roleTypes"/></td>
            </tr>
            <tr>
                <td><input type="button" value="Submit" onclick="saveUser()"/></td>
            </tr>
        </table>

    </sf:form>
</div>
<script>
    function saveUser() {
        document.getElementById('userForm').action = '<c:url value="/users"/>';
        document.getElementById('userForm').submit();
    }

</script>