$(":button").click(function () {
    $("#costumerForm").append("<input type='text' value='" + $(this).attr("id") + "'/>").submit();
});