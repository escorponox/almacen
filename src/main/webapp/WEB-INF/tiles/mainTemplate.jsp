<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Almacen</title>
    <style>
        body {
            margin-top: 20px;
            margin-bottom: 20px;
            background-color: #DFDFDF;
        }
    </style>
</head>
<body>
<div class="container" style="border: #C1C1C1 solid 1px; border-radius:10px;">
    <!-- Header -->
    <tiles:insertAttribute name="header"/>
    <!-- Menu Page -->
    <div style="height:auto;background-color:#9b9b9b;">
        <tiles:insertAttribute name="menu"/>
    </div>
    <!-- Body Page -->
    <div style="height:auto;background-color:#FCFCFC;">
        <tiles:insertAttribute name="body"/>
    </div>
    <!-- Footer Page -->
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>