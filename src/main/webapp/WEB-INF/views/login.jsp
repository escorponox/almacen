<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .error {
        padding: 15px;
        margin-bottom: 20px;
        border-radius: 4px;
        color: #a94442;
        background-color: #f2dede;
        border: 1px solid #ebccd1;
    }

    .msg {
        padding: 15px;
        margin-bottom: 20px;
        border-radius: 4px;
        color: #31708f;
        background-color: #d9edf7;
        border: 1px solid #bce8f1;
    }

    #login-box {
        width: 300px;
        padding: 20px;
        margin-left: 10%;
        background: #fff;
        -webkit-border-radius: 2px;
        -moz-border-radius: 2px;
        /*border: 1px solid #000;*/
    }
</style>
<div id="login-box">

    <h3>Login with Username and Password</h3>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <form name='loginForm'
          action="<c:url value='/j_spring_security_check' />" method='POST'>

        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password'/></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                                       value="Submit"/></td>
            </tr>
        </table>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>

    </form>
</div>