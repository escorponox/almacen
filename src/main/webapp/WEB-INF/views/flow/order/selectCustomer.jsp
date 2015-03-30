<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div>
    <h2>Customer identification</h2>
    <sf:form role="form">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>

        <div class="form-group">
            <label for="nif">NIF</label>
            <input type="text" class="form-control" id="nif" name="nif"
                   placeholder="NIF">
        </div>

        <button type="submit" class="btn btn-default" name="_eventId_nifEntered">Lookup Customer</button>

    </sf:form>
</div>