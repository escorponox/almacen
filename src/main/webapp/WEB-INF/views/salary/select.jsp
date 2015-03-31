<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <h2>Select Month</h2>
    <sf:form role="form" action="${pageContext.request.contextPath}/salary/show" method="post">

        <div class="form-group">
            <label for="month">Month</label>
            <input type="month" name="month" id="month"/>
        </div>

        <button type="submit" class="btn btn-default">Submit</button>

    </sf:form>
</div>