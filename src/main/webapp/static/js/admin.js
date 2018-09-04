$( document ).ready(function() {
    fillOrdersTable();
    getCoffeeMachineLevels();
});


var fillOrdersTable = function () {
    $.ajax({
        type: 'post',
        url: '/admin',
        data: JSON.stringify({action: 'get_orders'}),
        contentType: 'application/json',
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

var makeOrder = function (id) {
    $.ajax({
        type: 'post',
        url: '/admin',
        data: JSON.stringify({action: 'make_order', order_id: id}),
        contentType: 'application/json',
        success: function(data){
            $('.orders-table tr').firstChild.hide()
        }
    });
};

var getCoffeeMachineLevels = function () {
    $.ajax({
        type: 'post',
        url: '/admin',
        data: JSON.stringify({action: 'get_coffeemachine_levels'}),
        contentType: 'application/json',
        success: function(data){
            var coffeemachine_data = JSON.parse(data);
            console.log(coffeemachine_data.water);
            var td = '';
            td += '<tr><td>' + coffeemachine_data.water + '</td><td>' + coffeemachine_data.bean + '</td><td>' + coffeemachine_data.ground + '</td></tr>';
            $('.coffee_machine_levels').append(td);
        }
    });
};