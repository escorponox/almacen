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
    <h2>New Line</h2>
    <sf:form method="post" modelAttribute="itemSelect" role="form">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">

        <div class="row" style="padding-top: 10px">
            <div class="col-xs-12 col-sm-12 col-md-2"><sf:label class="control-label"
                                                                path="code">Item Code</sf:label></div>
            <div class="col-xs-6 col-md-4"><sf:input class="form-control" path="code"/></div>
            <div class="col-xs-6 col-md-4"><sf:errors class="label label-danger" path="code"/></div>
        </div>
        <div class="row" style="padding-top: 10px">
            <div class="col-xs-12 col-sm-12 col-md-2"><sf:label class="control-label"
                                                                path="name">Item Name</sf:label></div>
            <div class="col-xs-6 col-md-4"><sf:input class="form-control" path="name" readonly="true"
                                                     tabindex="-1"/></div>
        </div>
        <div class="row" style="padding-top: 10px">
            <div class="col-xs-12 col-sm-12 col-md-2"><sf:label class="control-label"
                                                                path="price">Item Price</sf:label></div>
            <div class="col-xs-6 col-md-4"><sf:input class="form-control" path="price" readonly="true"
                                                     tabindex="-1"/></div>
        </div>
        <div class="row" style="padding-top: 10px">
            <div class="col-xs-12 col-sm-12 col-md-2"><sf:label class="control-label"
                                                                path="quantity">Quantity</sf:label></div>
            <div class="col-xs-6 col-md-4"><sf:input class="form-control" path="quantity"
                                                     onchange="calculateLineTotal();"/></div>
            <div class="col-xs-6 col-md-4"><sf:errors class="label label-danger" path="quantity"/></div>
        </div>
        <div class="row" style="padding-top: 10px">
            <div class="col-xs-12 col-sm-12 col-md-2"><sf:label class="control-label"
                                                                path="lineAmount">Total</sf:label></div>
            <div class="col-xs-6 col-md-4"><sf:input class="form-control" path="lineAmount" readonly="true"
                                                     tabindex="-1"/></div>
        </div>
        <div style="padding-top: 10px">
            <button type="submit" class="btn btn-default" name="_eventId_submitLine">Submit Line</button>
            <button type="submit" class="btn btn-default" name="_eventId_cancelLine">Cancel</button>
        </div>


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