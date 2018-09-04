$( document ).ready(function() {
    fillOrders();
});

var fillOrders = function () {
    $.ajax({
        type: "POST",
        url: "/admin",
        success: function(data){
            var tableData = JSON.parse(data);
            for (var i in tableData['orders']){
                var order = tableData['orders'];
                var tr = '';
                tr += '<tr><td>' + order[i].id + '</td><td>' + order[i].customerName + '</td><td>' + order[i].customerRoom + '</td><td>' + order[i].orderTime + '</td></tr>'
                $('.orders-table').append(tr);
            }
        }
    });
};
