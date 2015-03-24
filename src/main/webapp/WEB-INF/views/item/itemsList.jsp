<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<s:url var="baseURL" value=""/>
<c:import url="${baseURL}/resources/xml/itemList.xsl" var="xslt"/>


<x:transform xml="${xmlItems}" xslt="${xslt}"/>
