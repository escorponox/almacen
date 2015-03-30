<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
    <title>EXES WareHouse Management</title>

    <script src="<c:url value='/resources/js/jquery-2.1.3.min.js'/>"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
    <link href="<c:url value='/resources/css/sticky-footer-navbar.css'/>" rel="stylesheet">
</head>
<body>

<!-- Menu Page -->
<div id="wrap">

    <tiles:insertAttribute name="menu"/>

    <!-- Body Page -->
    <div class="container">
        <tiles:insertAttribute name="body"/>
    </div>
</div>
<!-- Footer Page -->
<footer class="footer">
    <tiles:insertAttribute name="footer"/>
</footer>

</body>
</html>