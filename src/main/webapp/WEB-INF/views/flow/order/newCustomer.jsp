<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div>
    <h2>New customer registration: </h2>
    <sf:form method="post" modelAttribute="customer">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
        <table cellspacing="3">
            <tr>
                <td><sf:label path="phoneNumber">Phone Number: </sf:label></td>
                <td><sf:input type="text" path="phoneNumber"/></td>
                <td><sf:errors path="phoneNumber"/></td>
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
                <td><sf:label path="zipCode">ZIP Code: </sf:label></td>
                <td><sf:input type="text" path="zipCode"/></td>
                <td><sf:errors path="zipCode"/></td>
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