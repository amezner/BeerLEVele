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
                country: $("#country").val(),
                city: $("#city").val(),
                address: $("#address").val(),
                postalcode: $("#postalcode").val(),
                email: $("#email").val(),
                phone: $("#phone").val(),
                loyalty: $("#loyalty").is(":checked"),
                discount: $("#discount").val()
            })
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        });
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
                type: $("#type").val(),
                alcoholcontent: $("#alcoholcontent").val(),
                bottlesize: $("#bottlesize").val(),
                purchaseprice: $("#purchaseprice").val(),
                sellingprice: $("#sellingprice").val(),
                onstockquantity: $("#onstockquantity").val()
            })
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        });
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
    $("#filters").click(function () {
        $.ajax({
            type: 'GET',
            url: 'resources/stock/filterstock/'+$('#filterstock').val(),
            dataType: "json",
            contentType: "application/json",
            headers: {'authToken': token},
            complete: function (responseText) {
            },
        });
    }
    );
    $("#filterc").click(function () {
        $.ajax({
            type: 'GET',
            url: 'resources/customer/filtercustomer/'+$('#filtercustomer').val(),
            dataType: "json",
            contentType: "application/json",
            headers: {'authToken': token},
            complete: function (responseText) {
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

    $("#emptycart").click(function () {

        $.ajax({
            url: 'resources/order/emptycart',
            type: 'DELETE',
            dataType: "json",
            contentType: "application/json",
            headers: {'authToken': token},
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#addtocart").click(function () {
        $.ajax({
            url: 'resources/order/putinthecart',
            type: 'POST',
            headers: {'authToken': token},
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                stock_id: $("#stockidtocart").val(),
                quantity: $("#stockquantitytocart").val()
            })
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        });
    });

    $("#deletefromcart").click(function () {
        $.ajax({
            url: 'resources/order/deleteitemfromcart/' + $("#stockidtocart").val(),
            type: 'DELETE',
            headers: {'authToken': token},
            dataType: "json",
            contentType: "application/json",
            success: function (responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
            }}
        )
    });

    $("#getcustomer").click(function () {
        $.ajax({
            url: 'resources/customer/getcustomer/' + $("#customeridtoget").val(),
            type: 'GET',
            dataType: "json",
            contentType: "application/json",
            headers: {'authToken': token},
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#deletecustomer").click(function () {
        $.ajax({
            url: 'resources/customer/deletecustomer/' + $("#customeridtodelete").val(),
            type: 'DELETE',
            dataType: "json",
            contentType: "application/json",
            headers: {'authToken': token},
            success: function (responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
            }}
        )
    });

    $("#getallinvoices").click(function () {

        $.ajax({
            url: 'resources/invoice/getallinvoices',
            type: 'GET',
            dataType: "json",
            contentType: "application/json", headers: {'authToken': token},
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#getallcustomer").click(function () {

        $.ajax({
            url: 'resources/customer/getallcustomer',
            type: 'GET',
            dataType: "json",
            contentType: "application/json", headers: {'authToken': token},
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#getstock").click(function () {
        $.ajax({
            url: 'resources/stock/getstock/' + $("#stockidtoget").val(),
            type: 'GET',
            dataType: "json",
            contentType: "application/json",
            headers: {'authToken': token},
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#deletestock").click(function () {
        $.ajax({
            url: 'resources/stock/deletestock/' + $("#stockidtodelete").val(),
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

    $("#getallstock").click(function () {
        $.ajax({
            url: 'resources/stock/getallstock',
            type: 'GET',
            dataType: "json",
            contentType: "application/json",
            headers: {'authToken': token},
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#getinvoice").click(function () {
        $.ajax({
            url: 'resources/invoice/getinvoice/' + $("#invoicenumber").val(),
            type: 'GET',
            dataType: "json",
            contentType: "application/json",
            headers: {'authToken': token},
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#closeinvoice").click(function () {
        $.ajax({
            url: 'resources/invoice/closeinvoice',
            type: 'POST',
            headers: {'authToken': token},
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                customer_id: $("#customerforinvoice").val()
            })
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        });
    });
    
    $("#stockconsumption").click(function () {
        $.ajax({
            url: 'resources/invoice/stockconsumption',
            type: 'GET',
            dataType: "json",
            contentType: "application/json",
            headers: {'authToken': token},
        }, function (responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        })
    });

    $("#profitperinvoice").click(function () {
        $.ajax({
            url: 'resources/invoice/profitperinvoice',
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
