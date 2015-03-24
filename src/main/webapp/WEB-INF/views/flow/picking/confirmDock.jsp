<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>

    <sf:form method="post" modelAttribute="container" role="form" class="form-horizontal">

        <div class="col-xs-12">
            <h2>Confirm Dock: </h2>
        </div>
        <div class="col-xs-12">
            <sf:errors class="label label-danger"/>
        </div>


        <div class="col-xs-12">
            <sf:hidden path="id"/>

            <sf:label path="outgoingDock.name" class="control-label col-sm-4">Destination Dock</sf:label>
            <div class="col-sm-4">
                <sf:input path="outgoingDock.name" class="form-control" readonly="true" tabindex="-1"/>
            </div>
        </div>

        <div class="col-xs-12">
            <sf:label class="control-label col-sm-4" path="outgoingDock.id">Select Dock</sf:label>
            <div class="col-sm-4">
                <sf:select path="outgoingDock.id" class="form-control">
                    <sf:options items="${docks}" itemValue="id" itemLabel="name"/>
                </sf:select>
            </div>
        </div>

        <div class="col-xs-12">
            <div class="col-sm-4">

            </div>
            <div class="col-xs-4">
                <button class="btn btn-default" type="submit" name="_eventId_selectedDock">Confirm</button>
            </div>
        </div>
    </sf:form>

</div>