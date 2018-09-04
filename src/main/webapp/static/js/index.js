$(":button").click(function () {
    $("#customerForm").append("<input type='text' name='coffeeType' value='" + $(this).attr("id") + "'/>").submit();
});