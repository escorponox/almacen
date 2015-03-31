<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Login with Username and Password</h3>

<form class="form-horizontal" role="form" name='loginForm'
      action="<c:url value='/j_spring_security_check' />" method='POST'>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-4">
            <c:if test="${not empty error}">
                <div class="label label-danger">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="label label-primary">${msg}</div>
            </c:if>
        </div>
    </div>
    <div class="form-group">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">User</label>

            <div class="col-sm-4">
                <input class="form-control" type='text' id="username" name='username' placeholder="Username">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password</label>

            <div class="col-sm-4">
                <input class="form-control" id="password" type='password' name='password' placeholder="Password"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-4">
            <button class="btn btn-default" name="submit" type="submit">Submit</button>
        </div>
    </div>

    <div>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </div>
</form>
