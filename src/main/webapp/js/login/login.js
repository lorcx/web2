// JavaScript Document
//支持Enter键登录
		document.onkeydown = function(e){
			if($(".bac").length==0)
			{
				if(!e) e = window.event;
				if((e.keyCode || e.which) == 13){
					var obtnLogin=document.getElementById("submit_btn");
					obtnLogin.focus();
				}
			}
		};

    	$(function(){
			/**
			 $('.page-container form').submit(function(){
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        if(username == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if(password == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.password').focus();
            });
            return false;
        }
    });

			 $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });
			 */
			//提交表单
			$('#submit_btn').click(function(){
				//show_loading();
			//	var myReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
			//	if($('#email').val() == ''){
			//		show_err_msg('邮箱还没填呢！');
			//		$('#email').focus();
			//	}else if(!myReg.test($('#email').val())){
			//		show_err_msg('您的邮箱格式错咯！');
			//		$('#email').focus();
			//	}else if($('#password').val() == ''){
			//		show_err_msg('密码还没填呢！');
			//		$('#password').focus();
			//	}else{
					//ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
					//show_msg('登录成功咯！  正在为您跳转...','/');
			//	}
			});
		});
