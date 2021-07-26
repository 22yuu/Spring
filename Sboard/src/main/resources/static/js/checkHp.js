var isHpOk = false;

$(function(){
    		
    		$('input[name=hp]').focusout(function(){
    			
    			var hp = $(this).val();
    			var param = {'hp':hp};
    			
    			$.ajax({
    				url:'/Sboard/register/checkHp',
    				type:'get',
    				data: param,
    				dataType:'json',
    				success:function(data){
    					if(data == 1) {
    						$('.resultHp').css('color', 'red').text('이미 사용중인 번호 입니다.');
							isHpOk = false;
    					} else {
    						$('.resultHp').css('color', 'green').text('사용 가능한 번호 입니다.')
							isHpOk = true;	
    					}
    				}
    			});
    		});
    		
    	});