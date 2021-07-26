var isEamilOk = false;

$(function(){
    		
    		$('input[name=email]').focusout(function(){
    			
    			var email = $(this).val();
    			var param = {'email':email};
    			
    			$.ajax({
    				url:'/Sboard/register/checkEmail',
    				type:'get',
    				data: param,
    				dataType:'json',
    				success:function(data){
    					if(data == 1) {
    						$('.resultEmail').css('color', 'red').text('이미 사용중인 이메일 입니다.');
							isEamilOk = false;	
    					} else {
    						$('.resultEmail').css('color', 'green').text('사용 가능한 이메일 입니다.')
							isEamilOk = true;	
    					}
    				}
    			});
    		});
    		
    	});