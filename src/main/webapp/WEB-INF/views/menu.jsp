<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header navbar-left">
        <a class=" btn btn-primary navbar-btn" href="<s:url value="/"/>">Home</a>

        <security:authorize access="hasRole('ROLE_ADMIN')">
            <a class=" btn btn-primary navbar-btn" href="<s:url value="/users?list"/>">Users Management</a>
        </security:authorize>

        <security:authorize access="hasAnyRole('ROLE_STORE','ROLE_ADMIN')">
            <a class=" btn btn-primary navbar-btn" href="<s:url value="/items/"/>">Item List</a>
        </security:authorize>

        <security:authorize access="hasAnyRole('ROLE_STORE','ROLE_ADMIN')">
            <a class=" btn btn-primary navbar-btn" href="<s:url value="/receipt/select"/>">Receipts</a>
        </security:authorize>

        <security:authorize access="hasAnyRole('ROLE_STORE','ROLE_ADMIN')">
            <a class=" btn btn-primary navbar-btn" href="<s:url value="/locate/assign"/>">Locate</a>
        </security:authorize>

        <security:authorize access="hasAnyRole('ROLE_SELLER','ROLE_ADMIN')">
            <a class=" btn btn-primary navbar-btn" href="<s:url value="/orderFlow"/>">Create Order</a>
        </security:authorize>

        <security:authorize access="hasAnyRole('ROLE_ADMIN')">
            <a class=" btn btn-primary navbar-btn" href="<s:url value="/release/"/>">Order Release</a>
        </security:authorize>

        <security:authorize access="hasAnyRole('ROLE_STORE','ROLE_ADMIN')">
            <a class=" btn btn-primary navbar-btn" href="<s:url value="/pickingFlow"/>">Picking</a>
        </security:authorize>

        <security:authorize access="hasAnyRole('ROLE_STORE','ROLE_ADMIN')">
            <a class=" btn btn-primary navbar-btn" href="<s:url value="/ship/"/>">Shipping</a>
        </security:authorize>

    </div>
    <div id="headerUserDiv" class="navbar-right">

        <security:authorize access="isAnonymous()">
            <div>
                <c:url value="/login" var="loginUrl"/>
                <a class=" btn btn-primary navbar-btn" id="loginLink" href="${loginUrl}"
                   onclick="formSubmit()">LogIn</a>
            </div>
        </security:authorize>


        <security:authorize access="isAuthenticated()">
            <c:url value="/j_spring_security_logout" var="logoutUrl"/>
            <div class="pull-left">
                <label class="btn btn-default navbar-btn disabled">Hello <security:authentication
                        property="principal.username"/></label>
            </div>
            <div class="pull-right">
                <form action="${logoutUrl}" method="post" id="logoutForm">
                    <a class=" btn btn-primary navbar-btn" id="logoutLink" onclick="formSubmit()">LogOut</a>
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
</nav>