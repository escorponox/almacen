<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>

    <sf:form method="post" modelAttribute="pickingForm" role="form" class="form-horizontal">

        <div class="col-xs-12">
            <h2>Picking: </h2>
        </div>
        <div class="col-xs-12">
            <sf:errors class="label label-danger"/>
        </div>


        <div class="col-xs-12">
            <sf:hidden path="pickingActionId"/>

            <sf:label path="orderCode" class="control-label col-sm-4">Order Code</sf:label>
            <div class="col-sm-4">
                <sf:input path="orderCode" class="form-control" readonly="true" tabindex="-1"/>
            </div>
        </div>

        <div class="col-xs-12">
            <sf:label class="control-label col-sm-4" path="orderLine">Order Line</sf:label>
            <div class="col-sm-4">
                <sf:input path="orderLine" class="form-control" readonly="true" tabindex="-1"/>
            </div>
        </div>

        <div class="col-xs-12">
            <sf:label class="control-label col-sm-4" path="locationName">Location</sf:label>
            <div class="col-sm-4">
                <sf:input path="locationName" class="form-control" readonly="true" tabindex="-1"/>
            </div>
        </div>

        <div class="col-xs-12">
            <sf:label class="control-label col-sm-4" path="itemCode">Item Code</sf:label>
            <div class="col-sm-4">
                <sf:input path="itemCode" class="form-control" readonly="true" tabindex="-1"/>
            </div>
        </div>

        <div class="col-xs-12">
            <sf:label class="control-label col-sm-4" path="itemName">Item Name</sf:label>
            <div class="col-sm-4">
                <sf:input path="itemName" class="form-control" readonly="true" tabindex="-1"/>
            </div>
        </div>

        <div class="col-xs-12">
            <sf:label class="control-label col-sm-4" path="ordered">Ordered Quantity</sf:label>
            <div class="col-sm-4">
                <sf:input path="ordered" class="form-control" readonly="true" tabindex="-1"/>
            </div>
        </div>

        <div class="col-xs-12">
            <sf:label class="control-label col-sm-4" path="itemCodeConfirmation">Confirm Item Code</sf:label>
            <div class="col-sm-4">
                <sf:input path="itemCodeConfirmation" class="form-control"/>
            </div>
            <div class="col-xs-4">
                <sf:errors path="itemCodeConfirmation" class="label label-danger"/>
            </div>
        </div>


        <div class="col-xs-12">
            <sf:label class="control-label col-sm-4" path="picked">Confirm Quantity</sf:label>
            <div class="col-sm-4">
                <sf:input path="picked" class="form-control"/>
            </div>
            <div class="col-xs-4">
                <sf:errors path="picked" class="label label-danger"/>
            </div>
        </div>

        <div class="col-xs-12">
            <div class="col-sm-4">

            </div>
            <div class="col-xs-4">
                <button class="btn btn-default" type="submit" name="_eventId_submitPicking">Confirm</button>
            </div>
        </div>
    </sf:form>

</div>