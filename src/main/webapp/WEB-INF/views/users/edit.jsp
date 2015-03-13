<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<style>
    span[id$=".errors"] {
        color: #e30002;
    }
</style>
<div>
    <h2>Edit User</h2>
    <sf:form method="post" id="userForm" modelAttribute="userEditForm">
        <table cellspacing="5" style="text-align: center">
            <tr>
                <sf:hidden path="user.id"/>
                <td><sf:label path="user.username">User: </sf:label></td>
                <td><sf:input path="user.username"/></td>
                <td><sf:errors path="user.username"/></td>
            </tr>
            <tr>
                <td><sf:label path="user.enabled">Enabled: </sf:label></td>
                <td><sf:checkbox path="user.enabled"/></td>
                <td><sf:errors path="user.enabled"/></td>
            </tr>
            <tr>
                <td><sf:label path="user.commission">Commission: </sf:label></td>
                <td><sf:input path="user.commission"/></td>
                <td><sf:errors path="user.commission"/></td>
            </tr>
            <tr>
                <td><sf:label path="roleTypeEnums">Roles: </sf:label></td>
                <td><sf:checkboxes path="roleTypeEnums" items="${roleTypesList}"/></td>
                <td><sf:errors path="roleTypeEnums"/></td>
            </tr>
            <tr>
                <td><input type="button" value="Submit" onclick="saveUser()"/></td>
            </tr>
        </table>

    </sf:form>
</div>
<script>
    function saveUser() {
        document.getElementById('userForm').action = '<c:url value="/users/save"/>';
        document.getElementById('userForm').submit();
    }

</script>