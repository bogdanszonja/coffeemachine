var coffeeType;
var customerRoom;
var customerName;

$(".coffee-selector-wrapper button").click(function () {
    event.preventDefault();
    coffeeType = $(this).attr("id");
    $(".coffee-selector-wrapper").fadeOut();
    $(".room-selector-wrapper").fadeIn();
});

$(".room-selector-wrapper button").click(function () {
    event.preventDefault();
    customerRoom = $(this).attr("id");
    $(".room-selector-wrapper").fadeOut();
    $(".customer-name-wrapper").fadeIn();
});

$("#customerForm button").click(function () {
    event.preventDefault();
    customerName = $("#customerForm #customerName").val();
    $.ajax({
        type: 'post',
        url: '/',
        data: "coffeeType=" + coffeeType + "&customerRoom=" + customerRoom + "&customerName=" + customerName,
        success: function(data){
            $(".customer-name-wrapper").fadeOut();
            $(".success").delay(400).fadeIn();
            $(".fill-coffee").delay(600).slideUp(2000);
            $(".coffee-flow").delay(600).fadeIn(0).delay(1500).fadeOut(0);
        }
    });
});

// $(".coffee-selector-wrapper button").click(function () {
//     event.preventDefault();
//     $("#customerForm").append("<input type='hidden' name='coffeeType' value='" + $(this).attr("id") + "'/>");
//     $(".coffee-selector-wrapper").fadeOut();
//     $(".room-selector-wrapper").fadeIn();
//
// });
//
// $(".room-selector-wrapper button").click(function () {
//     event.preventDefault();
//     $("#customerForm").append("<input type='hidden' name='customerRoom' value='" + $(this).attr("id") + "'/>");
//     $(".room-selector-wrapper").fadeOut();
//     $(".customer-name-wrapper").fadeIn();
//
// });



//
// $(":button").click(function () {
//     $("#customerForm").append("<input type='text' name='coffeeType' value='" + $(this).attr("id") + "'/>").submit();
// });






$(window).on('load', function() {
    $('.title').delay(300).fadeIn(2000).delay(2500).fadeOut(3000, function () {
        $('.content-wrapper').delay(300).fadeIn(2000);
    });
});