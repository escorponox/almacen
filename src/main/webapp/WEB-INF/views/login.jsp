<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .error {
        padding: 15px;
        margin-bottom: 20px;
        border-radius: 4px;
        color: #a94442;
        background-color: #f2dede;
        border: 1px solid #ebccd1;
    }

    .msg {
        padding: 15px;
        margin-bottom: 20px;
        border-radius: 4px;
        color: #31708f;
        background-color: #d9edf7;
        border: 1px solid #bce8f1;
    }

    #login-box {
        padding: 20px;
        margin-left: 10%;
        background: #fff;
        -webkit-border-radius: 2px;
        -moz-border-radius: 2px;
        /*border: 1px solid #000;*/
    }
</style>
<div id="login-box">

    <h3>Login with Username and Password</h3>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <form class="form-horizontal" role="form" name='loginForm'
          action="<c:url value='/j_spring_security_check' />" method='POST'>

        <div class="form-group">
            <div class="form-group">
                <label for="username" class="col-lg-2 control-label">User</label>

                <div class="col-lg-10">
                    <input class="form-control" type='text' id="username" name='username' placeholder="Username">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-lg-2 control-label">Password</label>

                <div class="col-lg-10">
                    <input class="form-control" id="password" type='password' name='password' placeholder="Password"/>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button class="btn btn-default" name="submit" type="submit">Submit</button>
            </div>
        </div>

        <div>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </div>
    </form>
</div>