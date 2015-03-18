<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <h2>Create Pizza: </h2>
    <sf:form method="post">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">

        <h3>Code: </h3>
        <sf:input path="code"/>

        <h3>Ingredients: </h3>
        <sf:input path="orderedQuantity"/>

        <table>
            <tr>
                <td><label for="code">Item Code: </label></td>
                <td><input type="text" id="code" name="code"/></td>
            </tr>
            <tr>
                <td><label for="name">Item Name: </label></td>
                <td><input type="text" id="name" name="name" readonly tabindex="-1"/></td>
            </tr>
            <tr>
                <td><label for="price">Item Price: </label></td>
                <td><input type="text" id="price" name="price" readonly tabindex="-1"/></td>
            </tr>
            <tr>
                <td><label for="quantity">Item Price: </label></td>
                <td><input type="text" id="quantity" name="quantity"/></td>
            </tr>
            <tr>
                <td><label for="lineAmount">Total: </label></td>
                <td><input type="text" id="lineAmount" name="lineAmount" readonly tabindex="-1"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="_eventId_addLine" value="Add Pizza"/>
                </td>
                <td>
                    <input type="submit" name="_eventId_cancel" value="Cancel"/>
                </td>
            </tr>
        </table>

    </sf:form>
</div>