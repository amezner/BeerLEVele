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
            contentType: "application/json; charset=UTF-8",
            headers: {'authToken': token},
            data: {
                name: $("#name").val(),
                address: $("#address").val(),
                email: $("#email").val(),
                phone: $("#phone").val(),
                loyalty: $("#loyalty").is(":checked"),
                discount: $("#discount").val()
            }
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#add_stock").click(function () {
        $.ajax({
            url: 'resources/stock/savestock',
            type: 'POST',
            contentType: "application/json; charset=UTF-8",
            headers: {'authToken': token},
            data: {
                name: $("#stockname").val(),
                description: $("#stockdescription").val(),
                purchaseprice: $("#purchaseprice").val(),
                sellingprice: $("#sellingprice").val(),
                onstockquantity: $("#onstockquantity").val(),
                type: $("#type").val(),
            }
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#getall").click(function () {

        $.ajax({
            url: 'resources/customer/getallcustomer',
            type: 'GET',
            contentType: "application/json; charset=UTF-8",
            headers: {'authToken': token},
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#deletecustomer").click(function () {
        $.ajax({
            url: 'resources/customer/deletecustomer/' + $("#azonosito").val(),
            type: 'DELETE',
            contentType: "application/json; charset=UTF-8",
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
            data: {username: $('#username').val(), password: $('#password').val()},
            contentType: "application/json; charset=UTF-8",
            complete: function (responseText) {
                console.log(responseText);
                token = responseText.responseText;
                console.log(token);
            },
        });
    }
    );

    $("#logout").click(function () {
        $.ajax({
            url: 'resources/authentication/logout',
            type: 'POST',
            headers: {'authToken': token}
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        });
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
