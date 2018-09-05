$(".coffee-selector-wrapper button").click(function () {
    event.preventDefault();
    $("#customerForm").append("<input type='hidden' name='coffeeType' value='" + $(this).attr("id") + "'/>");
    $(".coffee-selector-wrapper").slideDown();
    $(".room-selector-wrapper").slideDown();

});



//
// $(":button").click(function () {
//     $("#customerForm").append("<input type='text' name='coffeeType' value='" + $(this).attr("id") + "'/>").submit();
// });






$(window).on('load', function() {
    $('.title').delay(300).fadeIn(2000).delay(2500).fadeOut(3000, function () {
        $('.content-wrapper').delay(300).fadeIn(2000);
    });
});