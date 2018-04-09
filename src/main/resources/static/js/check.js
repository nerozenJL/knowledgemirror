var Isusername = false;
$(document).ready(function(){
	$("#email_input").bind("blur",checkemail);    //检查邮箱
    $("#email_input").bind("focus",function(){    //获取焦点时设为空——邮箱
        $("#email").html("");
    });

	$("#password_input2").bind("blur",checkpassword);    //检查密码
    $("#password_input2").bind("focus",function(){    //获取焦点时设为空——重复密码
        $("#password").html("");
    });

    $("#password_input1").bind("blur",checkpassword);    //检查密码
    $("#password_input1").bind("focus",function(){    //获取焦点时设为空——密码
        $("#password").html("");
    });

	$("#username_input").bind("blur",checkusername);   //检查用户名是否已经存在
    $("#username_input").bind("focus",function(){    //获取焦点时设为空——用户名
        $("#username").html("");
    });

	$("#birth_input").bind("blur",checkbirth);    //检查生日是否正确
    $("#birth_input").bind("focus",function(){    //获取焦点时设为空——生日
        $("#birth").html("");
    });
    
	$("#lg1_input").bind("focus",function(){    //获取焦点时设为空——用户名
		$("#username_login").html("");
	});
	$("#lg2_input").bind("focus",function(){    //获取焦点时设为空——密码
		$("#password_login").html("");
	});
    $("#rgs2_span").bind("click",register);    //提交注册信息
    $("#lg2_button").bind("click",login);    //检查用户名密码是否符合
	 /*    if(sessionStorage.getElem('msg')!=null){
        alert(sessionStorage.getElem('msg'))
    }*/
})



//检查邮箱
function checkemail(){
	var pattern = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
	//console.log(pattern.test(email.value));
	if($('#email_input').val() === ""){
		$('#email').html("邮箱不能为空");
		return false;
	}else if(!pattern.test($('#email_input').val())){
		$('#email').html("邮箱无效");
		return false;
	}else{
		$('#email').html("");
		return true;
	}
}
//检查密码
function checkpassword(){
	if($('#password_input1').val() === ""){
        $('#password').html("密码不能为空");
        return false;
	}else if($('#password_input1').val() === $('#password_input2').val()){
		$('#password').html("");
		return true;
	}else{
		$('#password').html("两次密码不相同");
		return false;
	}
}
//检查用户名是否已经存在
function checkusername(){

	var msg = {
		user_name:$("#username_input").val(),
	};
	if($("#username_input").val() === ""){
		$("#username").html("用户名不能为空");
		Isusername = false;
		return false;
	}else{
		$.ajax({
			type:"POST",
			url:"/checkUserName",
            contentType:"application/json;charset=utf-8",
			data:JSON.stringify(msg),
			    // data:"{'user_name:': '"+$("#username_input").val()+"'}",
				// data:{user_name:$("#username_input").val()},
				// data:{"user_name:"+$("#username_input").val()},
				// data:{"user_name="+$("#username_input").val()},
			dataType:"JSON",
			error:function(){
				Isusername = false;
				alert("error connection");
			},
			success:function(data){
				if(data.result === "success"){
					//$("#username").html("success");
					Isusername = true;
					return true;
				}else{
					$("#username").html("用户已存在");
					Isusername = false;
					return false;
				}
			},
		});
	}
}
//检查用户名密码是否符合
function login(){
	var msg = {
		user_name:$("#lg1_input").val(),
		user_password:$("#lg2_input").val(),
	}
	//console.log(JSON.stringify(msg));
	if($("#lg1_input").val() === ""){
		$("#username_login").html("用户名不能为空");
	}else if($("#lg2_input").val() === ""){
		$("#username_login").html("");
		$("#password_login").html("密码不能为空");
	}else{
		$.ajax({
			type:"POST",
			url:"/login",
            contentType:"application/json;charset=utf-8",
			data:JSON.stringify(msg),
				// data:"{'user_uame:': '"+$("#lg1_input").val()+"','user_password':'"+$("#lg2_input").val()+"'}",
				// data:{user_name:$("#lg1_input").val(),user_password:$("#lg2_input").val()},
				// data:{"user_name:"+$("#lg1_input").val+",user_password:"+$("#lg2_input").val()},
				// data:{"user_name="+$("#lg1_input").val+",user_password="+$("#lg2_input").val()},
			dataType:"JSON",
			error:function(){
				alert("ajax请求错误")
			},	
			success:function(data){
				if(data.result == "success"){
                   sessionStorage.setItem('user_name',data.user_name);
					window.location.href = "/html/pagepagehtml.html";
				}else{
					$("#username_login").html("用户名或密码错误");
				}
			},
		});
	}
}

//检查生日
function checkbirth(){
    var TheDate = getNowFormatDate();
    var myDate = $("#birth_input").val();
	if(myDate === ""){
		$("#birth").html("生日错误");
		return false;
	}else{
		//console.log(TheDate+","+myDate);
		return compareDate(TheDate,myDate);
	}
}
//获取YYYY-MM-NN格式的当前日期
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}
//比较日期大小
function compareDate(checkStartDate, checkEndDate) {
    var arys1= new Array();
    var arys2= new Array();
    if(checkStartDate != null && checkEndDate != null) {
        arys1=checkStartDate.split('-');
        var sdate=new Date(arys1[0],parseInt(arys1[1]-1),arys1[2]);
        arys2=checkEndDate.split('-');
        var edate=new Date(arys2[0],parseInt(arys2[1]-1),arys2[2]);
        if(sdate > edate) {
            $("#birth").html("");
            return true;
        }  else {
            $("#birth").html("出生日期错误");
            return false;
        }
    }
}


//提交注册信息
function register(){
	var msg = {
		user_name:$("#username_input").val(),
		user_password:$("#password_input1").val(),
		user_email:$("#email_input").val(),
		user_borndate:$("#birth_input").val(),
		user_evalution:$("#self_assessment").val(),
		user_education:$("#edu_background").val(),
		user_experience:$("#personal_experience").val(),
		user_honer:$("#honors_awards").val(),
		user_skill:$("#personal_skills").val(),
	};
	if(!Isusername|| !checkpassword()|| !checkemail() ||!checkbirth()){
		 checkusername();
		 alert("有必填项未填");
	}else{
        $.ajax({
            type:"POST",
            url:"/doRegister",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify(msg),
            dataType:"JSON",
            error:function(){
                alert("ajax请求错误");
            },
            success:function(data){
                if(data.result ==  "success"){
                    window.location.replace("/showLogin");
                    //使用Location的href属性跳转页面，前一页的Url会保存在浏览器的history历史中。
                    // 当用户点击浏览器的“后退”按钮可以返回前一页。如果你不想让返回前一页可使用Location.replace()代替:
                }else{
                    $("#username_login").html("网络出错");
                }
            },
        });
	}
	//console.log(JSON.stringify(msg));

}
