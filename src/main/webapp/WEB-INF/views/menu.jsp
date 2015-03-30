<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="sr-only">Desplegar navegación</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <security:authorize access="isAnonymous()">

                <c:url value="/login" var="loginUrl"/>
                <a class="btn btn-primary navbar-btn" id="loginLink" href="${loginUrl}"
                   onclick="formSubmit()">LogIn</a>

            </security:authorize>

            <security:authorize access="isAuthenticated()">
                <c:url value="/j_spring_security_logout" var="logoutUrl"/>
                <form action="${logoutUrl}" method="post" id="logoutForm">
                    <label class="btn btn-default navbar-btn disabled">Hello <security:authentication
                            property="principal.username"/></label>
                    <a class="btn btn-primary navbar-btn" id="logoutLink" onclick="formSubmit()">LogOut</a>
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form>

                <script>
                    function formSubmit() {
                        document.getElementById("logoutForm").submit();
                    }
                </script>

            </security:authorize>

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li>
                        <a href="<s:url value="/users?list"/>">Users Management</a></li>
                </security:authorize>

                <security:authorize access="hasAnyRole('ROLE_STORE','ROLE_ADMIN')">
                    <li>
                        <a href="<s:url value="/items/"/>">Item List</a></li>
                </security:authorize>

                <security:authorize access="hasAnyRole('ROLE_STORE','ROLE_ADMIN')">
                    <li>
                        <a href="<s:url value="/receipt/select"/>">Receipts</a></li>
                </security:authorize>

                <security:authorize access="hasAnyRole('ROLE_STORE','ROLE_ADMIN')">
                    <li>
                        <a href="<s:url value="/locate/assign"/>">Locate</a></li>
                </security:authorize>

                <security:authorize access="hasAnyRole('ROLE_SELLER','ROLE_ADMIN')">
                    <li>
                        <a href="<s:url value="/orderFlow"/>">Create Order</a></li>
                </security:authorize>

                <security:authorize access="hasAnyRole('ROLE_SELLER')">
                    <li>
                        <a href="<s:url value="/salary/"/>">Salary</a></li>
                </security:authorize>

                <security:authorize access="hasAnyRole('ROLE_ADMIN')">
                    <li>
                        <a href="<s:url value="/release/"/>">Order Release</a></li>
                </security:authorize>

                <security:authorize access="hasAnyRole('ROLE_STORE','ROLE_ADMIN')">
                    <li>
                        <a href="<s:url value="/pickingFlow"/>">Picking</a></li>
                </security:authorize>

                <security:authorize access="hasAnyRole('ROLE_STORE','ROLE_ADMIN')">
                    <li>
                        <a href="<s:url value="/ship/"/>">Shipping</a></li>
                </security:authorize>
            </ul>
        </div>
    </div>
</nav>