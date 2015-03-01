<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<a href="<s:url value="/"/>">Home</a>

<security:authorize access="hasRole('ROLE_ADMIN')">
    <a href="<s:url value="/users"/>">Users Management</a>
</security:authorize>