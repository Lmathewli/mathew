$(function (){  
    $("#sbumitBtn").on('click', function(){  
        $.ajax({  
            type : "post",  
            data : {  
            	orderNo : $('#out_trade_no').val(),  
            	subjectName : $('#WIDsubject').val(),  
            	fee : $('#WIDtotal_fee').val(),  
                WIDbody : $('#WIDbody').val()  
            },  
            url : window.location.protocol + '//'+ window.location.host + "/mathew/aliPay",  
            success : function(data) {  
            	console.log($(''));
                $('#returnAli').html(data);
            },
            error : function(da){  
            	console.log("test");
            }  
        });  
    })
});  