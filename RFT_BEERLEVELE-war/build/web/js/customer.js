/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var token;

$(document).ready(function () {
    var token;
    $("#add_customer").click(function () {
        $.ajax({
            url: 'resources/customer/savecustomer',
            type: 'POST',
            headers: {'authToken': token},
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                name: $("#name").val(),
                address: $("#address").val(),
                email: $("#email").val(),
                phone: $("#phone").val(),
                loyalty: $("#loyalty").is(":checked"),
                discount: $("#discount").val()
            }),
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#add_stock").click(function () {
        $.ajax({
            url: 'resources/stock/savestock',
            type: 'POST',
            headers: {'authToken': token},
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                name: $("#stockname").val(),
                description: $("#stockdescription").val(),
                purchaseprice: $("#purchaseprice").val(),
                sellingprice: $("#sellingprice").val(),
                onstockquantity: $("#onstockquantity").val(),
                type: $("#type").val(),
            }),
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#getall").click(function () {

        $.ajax({
            url: 'resources/customer/getallcustomer',
            type: 'GET',
            dataType: "json",
            contentType: "application/json", headers: {'authToken': token},
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#deletecustomer").click(function () {
        $.ajax({
            url: 'resources/customer/deletecustomer/' + $("#azonosito").val(),
            type: 'DELETE',
            dataType: "json",
            contentType: "application/json",
            headers: {
                'authToken': token
            },
            success: function (responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
            }}
        )
    });

    $("#authenticate").click(function () {
        $.ajax({
            type: 'POST',
            url: 'resources/authentication/login',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({username: $('#username').val(), password: $('#password').val()}),
            complete: function (responseText) {
                token = responseText.responseJSON.token;
            },
        });
    }
    );

    $("#logout").click(function () {
        $.ajax({
            url: 'resources/authentication/logout',
            type: 'POST',
            dataType: "json",
            contentType: "application/json",
            headers: {'authToken': token}
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        });
    });

    $("#getcart").click(function () {

        $.ajax({
            url: 'resources/order/getcart',
            type: 'GET',
            dataType: "json",
            contentType: "application/json", 
            headers: {'authToken': token},
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });
    
    $("#customeridbtn").click(function () {

        $.ajax({
            url: 'resources/customer/getcustomer/'+  $("#customerid").val(),
            type: 'GET',
            dataType: "json",
            contentType: "application/json", 
            headers: {'authToken': token},
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });
    
    
    
    /*   $("#getall").click(
     function () {
     var request = $.ajax({
     url: 'resources/customer/getallcustomer',
     });
     
     request.done(function (resp) {
     console.log(resp);
     });
     
     request.fail(function (jqXHR, textStatus) {
     console.log("Request failed: " + textStatus);
     });
     });
     */
}
);
