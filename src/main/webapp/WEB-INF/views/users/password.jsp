<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<style>
    span[id$=".errors"] {
        color: #e30002;
    }
</style>
<div>
    <sf:form method="post" id="userPasswordForm" modelAttribute="changePasswordForm">
        <div>
            <h2>Change password for user <c:out value="${changePasswordForm.username}"/></h2>
        </div>
        <div>
            <sf:errors/>
        </div>
        <table cellspacing="5" style="text-align: center">
            <tr>
                <sf:hidden path="userId"/>
                <sf:hidden path="username"/>
                <td><sf:label path="newPassword">New Password: </sf:label></td>
                <td><sf:password path="newPassword"/></td>
                <td><sf:errors path="newPassword"/></td>
            </tr>
            <tr>
                <td><sf:label path="repeatPassword">Repeat Password: </sf:label></td>
                <td><sf:password path="repeatPassword"/></td>
                <td><sf:errors path="repeatPassword"/></td>
            </tr>
            <tr>
                <td><input type="button" value="Submit" onclick="saveUserPassword()"/></td>
            </tr>
        </table>
    </sf:form>
</div>
<script>
    function saveUserPassword() {
        document.getElementById('userPasswordForm').action = '<c:url value="/users/changePassword"/>';
        document.getElementById('userPasswordForm').submit();
    }

</script>