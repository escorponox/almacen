<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="<c:url value="/resources/js/jquery-autocomplete.min.js" />"></script>
<style>
    .autocomplete-suggestions {
        border: 1px solid #999;
        background: #FFF;
        overflow: auto;
    }

    .autocomplete-suggestion {
        padding: 2px 5px;
        white-space: nowrap;
        overflow: hidden;
    }

    .autocomplete-selected {
        background: #F0F0F0;
    }

    .autocomplete-suggestions strong {
        font-weight: normal;
        color: #3399FF;
    }

    .autocomplete-group {
        padding: 2px 5px;
    }

    .autocomplete-group strong {
        display: block;
        border-bottom: 1px solid #000;
    }
</style>
<div>
    <h2>New Line: </h2>
    <sf:form method="post" modelAttribute="itemSelect">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">

        <table>
            <tr>
                <td><sf:label path="code">Item Code: </sf:label></td>
                <td><sf:input path="code"/></td>
                <td><sf:errors path="code"/></td>
            </tr>
            <tr>
                <td><sf:label path="name">Item Name: </sf:label></td>
                <td><sf:input path="name" readonly="true" tabindex="-1"/></td>
            </tr>
            <tr>
                <td><sf:label path="price">Item Price: </sf:label></td>
                <td><sf:input path="price" readonly="true" tabindex="-1"/></td>
            </tr>
            <tr>
                <td><sf:label path="quantity">Quantity: </sf:label></td>
                <td><sf:input path="quantity" onchange="calculateLineTotal();"/></td>
                <td><sf:errors path="quantity"/></td>
            </tr>
            <tr>
                <td><sf:label path="lineAmount">Total: </sf:label></td>
                <td><sf:input path="lineAmount" readonly="true" tabindex="-1"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="_eventId_submitLine" value="Submit Line"/>
                </td>
                <td>
                    <input type="submit" name="_eventId_cancelLine" value="Cancel"/>
                </td>
            </tr>
        </table>

    </sf:form>
</div>
<script>
    $(document).ready(function () {

        $('#code').autocomplete({
            serviceUrl: '${pageContext.request.contextPath}/ajax/itemCodeAutocomplete',
            paramName: "tagName",
            delimiter: ",",
            transformResult: function (response) {

                return {
                    //must convert json to javascript object before process
                    suggestions: $.map($.parseJSON(response), function (item) {

                        return {value: item, data: item};
                    })
                };
            },
            onSelect: function (suggestion) {
                fillItemData(suggestion.value);
            }
        });
    });

    function fillItemData(itemCode) {

        $.ajax({
            url: '${pageContext.request.contextPath}/ajax/fillItemData',
            data: "itemcode=" + itemCode,
            type: "GET",
            xhrFields: {
                withCredentials: true
            },
            success: function (data) {

                if (data.errorCode == 0) {

                    $('#name').val(data.data.itemName);
                    $('#price').val(data.data.itemPrice);
                    calculateLineTotal();
                }
                else {
                    alert(data.errorDescription);
                }
            },
            error: function () {
                alert("Error");
            }
        });
    }

    function calculateLineTotal() {
        var lineTotal = $('#price').val() * $('#quantity').val();

        if (isFinite(lineTotal)) {
            $('#lineAmount').val(lineTotal);
        }
    }
</script>