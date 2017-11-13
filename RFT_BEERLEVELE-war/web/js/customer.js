/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var token;

$(document).ready(function () {
    var token;
    $("#submit").click(function () {
        $.ajax({
            url: 'resources/customer/savecustomer',
            type: 'POST',
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
    /*   $("#getall").click(function () {
     
     console.log("asdasd");
     $.get('resources/customer/getallcustomer', {
     
     }, function (responseText) {
     $('#ajaxGetUserServletResponse').text(responseText);
     })
     });
     */
    $("#deletecustomer").click(function () {
        $.ajax({
            url: 'resources/customer/deletecustomer/' + $("#azonosito").val(),
            type: 'DELETE',
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
                token = responseText.responseText;
            },
        });
    }
    );

    $("#getall").click(
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

}
);
