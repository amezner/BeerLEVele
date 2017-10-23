/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function (){
    console.log("asdasd");
    $("#submit").click(function () {$.post('resources/Customer/SaveCustomer', {
                        name : $("#name").val(),
                        address:$("#address").val(),
                        email:$("#email").val(),
                        phone:$("#phone").val(),
                        loyalty:$("#loyalty").is(":checked"),
                        discount:$("#discount").val()
                        
                }, function(responseText) {
                        $('#ajaxGetUserServletResponse').text(responseText);
                })});
    });    
