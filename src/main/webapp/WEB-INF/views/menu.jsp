<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<a href="<s:url value="/"/>">Home</a>

<security:authorize access="hasRole('ROLE_ADMIN')">
    <a href="<s:url value="/users?list"/>">Users Management</a>
</security:authorize>

<security:authorize access="hasAnyRole('ROLE_STORE','ROLE_ADMIN')">
    <a href="<s:url value="/receipt/select"/>">Receipts</a>
</security:authorize>

<security:authorize access="hasAnyRole('ROLE_STORE','ROLE_ADMIN')">
    <a href="<s:url value="/locate/assign"/>">Locate</a>
</security:authorize>

<security:authorize access="hasAnyRole('ROLE_SELLER','ROLE_ADMIN')">
    <a href="<s:url value="/orderFlow"/>">Create Order</a>
</security:authorize>

<security:authorize access="hasAnyRole('ROLE_ADMIN')">
    <a href="<s:url value="/orderRelease"/>">Order Release</a>
</security:authorize>