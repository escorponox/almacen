<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div>
    <h2>New Customer</h2>
    <sf:form method="post" modelAttribute="customer" role="form">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-2"><sf:label class="control-label" path="nif">NIF: </sf:label></div>
            <div class="col-xs-6 col-md-4"><sf:input class="form-control" type="text" path="nif"/></div>
            <div class="col-xs-6 col-md-4"><sf:errors path="nif" class="label label-danger"/></div>
        </div>
        <div class="row" style="padding-top: 10px">
            <div class="col-xs-12 col-sm-12 col-md-2"><sf:label class="control-label"
                                                                path="name">Name: </sf:label></div>
            <div class="col-xs-6 col-md-4"><sf:input class="form-control" type="text" path="name"/></div>
            <div class="col-xs-6 col-md-4"><sf:errors path="name" class="label label-danger"/></div>
        </div>
        <div class="row" style="padding-top: 10px">
            <div class="col-xs-12 col-sm-12 col-md-2"><sf:label class="control-label"
                                                                path="address">Address: </sf:label></div>
            <div class="col-xs-6 col-md-4"><sf:input class="form-control" type="text" path="address"/></div>
            <div class="col-xs-6 col-md-4"><sf:errors path="address" class="label label-danger"/></div>
        </div>
        <div style="padding-top: 10px">
            <button type="submit" class="btn btn-default" name="_eventId_submit">Submit</button>
            <button type="submit" class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </div>

    </sf:form>
</div>