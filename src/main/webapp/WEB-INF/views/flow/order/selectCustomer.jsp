<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div>
    <h2>Customer identification: </h2>
    <sf:form>
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
        <table cellspacing="3">
            <tr>
                <td><label for="nif">NIF: </label></td>
                <td><input type="text" id="nif" name="nif"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="_eventId_nifEntered" value="Lookup Customer"/>
                </td>
            </tr>
        </table>
    </sf:form>
</div>