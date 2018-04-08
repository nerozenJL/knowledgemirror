    var number = 0;
	var msg2 = {
	};
	//获取上个html传送的数据，从session域中获取；
	/*var ID = sessionStorage.getItem('ID');
	var id = sessionStorage.getItem('id');*/
	var username = sessionStorage.getItem('user_name');

	var ID_1 = "123";
	var id_1 = "231";
	/*var username = "哈哈哈";*/
	
	$(document).ready(function(){
        var usernamebtn1 = $("<button>"+username+"</button>");
        $("#u52_input").append(usernamebtn1);
        usernamebtn1.attr("class","u53_button");

		var usernamebtn = $("<button>用户中心</button>");
		$("#u52_input").append(usernamebtn);
		usernamebtn.attr("class","u53_button");
        usernamebtn.bind("click",usermsg);


        var exitbtn = $("<button>退出</button>");
        $("#u52_input").append(exitbtn);
        exitbtn.attr("class","u53_button");
        exitbtn.bind("click",exitbtn);
		var infor = {
			"ID":ID_1,
			"id":id_1
		};

		$.ajax({
			type:"POST",
			dataType:"JSON",
			url:"/personalTest/loadQuestion",
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify(infor),
			error:function(XMLHttpRequest,textStatus,errorThrown){
				alert(XMLHttpRequest.status);
				return false;
			},
			success:function(msg){
                //console.log(msg);
				for(var i in msg){
/*
                    console.log(i+"  "+JSON.stringify(msg[i].question_answer));
				}*/
					var abc = i+"1";
					var bc = i+"2a";
					var cd = i+"3";
					number++;

					var one = $("<div></div>");
					$(".u58_1").append(one);
					one.attr("class","u58");
					one.attr("id",msg[i].question_id);

					if(msg[i].question_multiple === "1"){
						var two = $("<span>"+number+"."+msg[i].question_quest+"  (多选题)</span><br>");
					}else{
						var two = $("<span>"+number+"."+msg[i].question_quest+"</span>");
					}
					$("#"+msg[i].question_id).append(two);
					two.attr("class","u58_span1");
					

					var three = $("<div></div>");
					$("#"+msg[i].question_id).append(three);
					three.attr("class","u58_ul");
					three.attr("id",bc);

					if(msg[i].question_multiple === "yes"){
						var four = $("<br><label><input type='checkbox' name='"+i+"' class='"+msg[i].question_id+"' value='A' /><span></span><span style='vertical-align: top;' name = '"+i+"A'>"+
							"</span></label><br><br><label><input type='checkbox' name='"+i+"'  class='"+msg[i].question_id+"' value='B' /><span></span><span style='vertical-align: top;' name = '"+i+"B'>"+
							"</span></label><br><br><label><input type='checkbox' name='"+i+"'  class='"+msg[i].question_id+"' value='C' /><span></span><span style='vertical-align: top;' name = '"+i+"C'>"+
							"</span></label><br><br><label><input type='checkbox' name='"+i+"'  class='"+msg[i].question_id+"' value='D' /><span></span><span style='vertical-align: top;' name = '"+i+"D'>"+
							"</span></label><br>")
					}else{
						var four = $("<br><label><input type='radio' name='"+i+"'  class='"+msg[i].question_id+"' value='A' /><span></span><span style='vertical-align: top;' name = '"+i+"A'>"+
							"</span></label><br><br><label><input type='radio' name='"+i+"'  class='"+msg[i].question_id+"' value='B' /><span></span><span style='vertical-align: top;' name = '"+i+"B'>"+
							"</span></label><br><br><label><input type='radio' name='"+i+"'  class='"+msg[i].question_id+"' value='C' /><span></span><span style='vertical-align: top;' name = '"+i+"C'>"+
							"</span></label><br><br><label><input type='radio' name='"+i+"'  class='"+msg[i].question_id+"' value='D' /><span></span><span style='vertical-align: top;' name = '"+i+"D'>"+
							"</span></label><br>")
					}
					$("#"+bc).append(four);
					$("span[name="+i+"A]").text("A:"+msg[i].question_answer.A);
                    $("span[name="+i+"B]").text("B:"+msg[i].question_answer.B);
                    $("span[name="+i+"C]").text("C:"+msg[i].question_answer.C);
                    $("span[name="+i+"D]").text("D:"+msg[i].question_answer.D);
				}
			},
		});
	$("#u58_button").bind("click",submit);
	});



/*function submit1(){
	sessionStorage.setItem('ID',"哈哈哈");
	sessionStorage.setItem('id',"可是可是123sd");
	window.location.href = "1.html";
}*/

//提交所做答案并进行是否填写完毕判断
function submit(){
	msg2["user_name"] = username;
	msg2["id"] = id_1;
	for(i = 1;i <= number;i++){
		if($("input[name='"+i+"']").attr("type") == "checkbox"){
			var sta = $('input:checkbox[name="'+i+'"]:checked').val();
			//alert($("input[name='"+i+"']").attr("class"));	//找到当前元素 div 即返回json的第一个键值
			if(sta == null){
				alert("第"+i+"题未回答！");
				return false;
			}
			else{
				var id = $("input[name='"+i+"']").attr("class");
        		var text = $("input:checkbox[name='"+i+"']:checked").map(function(index,elem) {
      	   		   return $(elem).val();
     	 		  }).get().join(',');
					msg2[i] = {
					"question_id":id,
					"question_write_answer":text,
				}
			}	
		}else{
			var sta = $('input:radio[name="'+i+'"]:checked').val();
			//alert($("input[name='"+i+"']").attr("class"));	
			if(sta == null){
				/*alert("第"+i+"题未回答！");*/
				/*return false;*/
			}else{
				var id = $("input[name='"+i+"']").attr("class");
				msg2[i] = {
					"question_id":id,
					"question_write_answer":sta
				}
			}
		}
	}

	$.ajax({
		type:"POST",
		url:"/personalTest/submit",
		data:JSON.stringify(msg2),
		contentType:"application/json;charset=utf-8",
		dataType:"JSON",
		error:function(XMLHttpRequest,textStatus,errorThrown){
				alert(XMLHttpRequest.status);
				return false;
			},
		success:function(data){
			
			if(data.result ==  "success"){
				window.location.replace("/html/test/person_test_result.html");
			}else{
				alert("提交失败，请重新提交");
			}
		},
	});
}

		function setJson(jsonStr,name,value)
		{
		    if(!jsonStr)jsonStr="{}";
		    var jsonObj = JSON.parse(jsonStr);
		    jsonObj[name] = value;
		        return JSON.stringify(jsonObj)
		}
/*function boxnumber(){  //复选框的个数
	var j = 0;
	for(i = 0;i< $("input").length;i++){
		if($("input").eq(i).attr("type") == "checkbox"){
			j++;

		}
	}
	alert(j);
}*/

/*
页面测试
	var msg = {
		
		"1":{
			"question_id":"23",
			"question_quest":"111111",
			"question_answer":{
					"A":"123xxx",
					"B":"1xwexx",
					"C":"xxx",
					"D":"xsedxx"
				},
			"question_multiple":"1"
		},
		"2":{
			"question_id":"1",
			"question_quest":"222222",
			"question_answer":{
					"A":"123xxx",
					"B":"1wexxx",
					"C":"xxxxx",
					"D":"xxx"
				},
			"question_multiple":"0"
		},
		"3":{
			"question_id":"43",
			"question_quest":"333333",
			"question_answer":{
					"A":"123463xxx",
					"B":"1xxx",
					"C":"xvvvx",
					"D":"xxx"
				},
			"question_multiple":"0"
		},
	};
		for(var i in msg){
			var abc = i+"1";
			var bc = i+"2";
			var cd = i+"3";
			number++;

			var one = $("<div></div>");
			$(".u58_1").append(one);
			one.attr("class","u58");
			one.attr("id",msg[i].question_id);

			if(msg[i].question_multiple === "yes"){
				var two = $("<span>"+msg[i].question_quest+"  (多选题)</span>");
			}else{
				var two = $("<span>"+msg[i].question_quest+"</span>");
			}
			$("#"+msg[i].question_id).append(two);
			two.attr("class","u58_span1");
			

			var three = $("<div></div>");
			$("#"+msg[i].question_id).append(three);
			three.attr("class","u58_ul");
			three.attr("id",bc);

			if(msg[i].question_multiple === "yes"){
				var four = $("<br><label><input type='checkbox' name='"+i+"' class='"+msg[i].question_id+"' value='A' /><span></span><span style='vertical-align: top;'>"+msg[i].question_answer.A+
					"</span></label><br><br><label><input type='checkbox' name='"+i+"'  class='"+msg[i].question_id+"' value='B' /><span></span><span style='vertical-align: top;'>"+msg[i].question_answer.B+
					"</span></label><br><br><label><input type='checkbox' name='"+i+"'  class='"+msg[i].question_id+"' value='C' /><span></span><span style='vertical-align: top;'>"+msg[i].question_answer.C+
					"</span></label><br><br><label><input type='checkbox' name='"+i+"'  class='"+msg[i].question_id+"' value='D' /><span></span><span style='vertical-align: top;'>"+msg[i].question_answer.D+
					"</span></label>")
			}else{
				var four = $("<br><label><input type='radio' name='"+i+"'  class='"+msg[i].question_id+"' value='A' /><span></span><span style='vertical-align: top;'>"+msg[i].question_answer.A+
					"</span></label><br><br><label><input type='radio' name='"+i+"'  class='"+msg[i].question_id+"' value='B' /><span></span><span style='vertical-align: top;'>"+msg[i].question_answer.B+
					"</span></label><br><br><label><input type='radio' name='"+i+"'  class='"+msg[i].question_id+"' value='C' /><span></span><span style='vertical-align: top;'>"+msg[i].question_answer.C+
					"</span></label><br><br><label><input type='radio' name='"+i+"'  class='"+msg[i].question_id+"' value='D' /><span></span><span style='vertical-align: top;'>"+msg[i].question_answer.D+
					"</span></label>")
			}
			$("#"+bc).append(four);
		}*/



    function usermsg(){
        window.location.href = "/html/personalpage.html";
    }
    function exitbtn(){
        window.location.replace("login.html");
    }