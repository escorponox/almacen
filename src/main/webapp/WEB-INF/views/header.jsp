<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page session="true" %>

<style>
    .myClickableThingy {
        cursor: pointer;
    }
</style>

<div id="headerTitleDiv">EXES WareHouse Management</div>

<div id="headerUserDiv" style="float: right">

    <security:authorize access="isAnonymous()">
        <div>
            <c:url value="/login" var="loginUrl"/>
            <a id="loginLink" href="${loginUrl}" onclick="formSubmit()">LogIn</a>
        </div>
    </security:authorize>


    <security:authorize access="isAuthenticated()">
        <c:url value="/j_spring_security_logout" var="logoutUrl"/>
        <div style="float: left">
            Hello <security:authentication property="principal.username"/>&nbsp;|&nbsp;
        </div>
        <div style="float: right">
            <form action="${logoutUrl}" method="post" id="logoutForm">
                <a class="myClickableThingy" id="logoutLink" onclick="formSubmit()">LogOut</a>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>

            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>
        </div>
    </security:authorize>

</div>