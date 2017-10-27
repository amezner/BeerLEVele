/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function (){
    console.log("asdasd");
    $("#submit").click(function () {$.post('resources/customer/savecustomer', {
                        name : $("#name").val(),
                        address:$("#address").val(),
                        email:$("#email").val(),
                        phone:$("#phone").val(),
                        loyalty:$("#loyalty").is(":checked"),
                        discount:$("#discount").val()

                }, function(responseText) {
                        $('#ajaxGetUserServletResponse').text(responseText);
                })});
          $("#getall").click(function () {
              
              console.log("asdasd");
              $.get('resources/customer/getallcustomer', {
                             
                }, function(responseText) {
                        $('#ajaxGetUserServletResponse').text(responseText);
                })});  
          $("#deletecustomer").click(function(){
              console.log("delete");
              $.ajax({
                    url:'resources/customer/deletecustomer/11',
                    type: 'DELETE',
                    
                    success: function(responseText) {
                        $('#ajaxGetUserServletResponse').text(responseText);
              }})});  
            
            
    });    
