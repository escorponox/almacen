<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div>
    <h2>New customer registration: </h2>
    <sf:form method="post" modelAttribute="customer">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
        <table cellspacing="3">
            <tr>
                <td><sf:label path="nif">NIF: </sf:label></td>
                <td><sf:input type="text" path="nif"/></td>
                <td><sf:errors path="nif"/></td>
            </tr>
            <tr>
                <td><sf:label path="name">Name: </sf:label></td>
                <td><sf:input type="text" path="name"/></td>
                <td><sf:errors path="name"/></td>
            </tr>
            <tr>
                <td><sf:label path="address">Address: </sf:label></td>
                <td><sf:input type="text" path="address"/></td>
                <td><sf:errors path="address"/></td>
            </tr>
            <tr>
                <td><sf:label path="defaultDock.name">Default Dock: </sf:label></td>
                <td><sf:input type="text" path="defaultDock.name"/></td>
                <td><sf:errors path="defaultDock.name"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="_eventId_submit" value="Submit"/>
                </td>
                <td>
                    <input type="submit" name="_eventId_cancel" value="Cancel"/>
                </td>
            </tr>
        </table>

    </sf:form>
</div>