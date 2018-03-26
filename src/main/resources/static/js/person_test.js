	var question_id;
	var question_quest ;
	
	var question_answer;
	var question_multiple;


	var A = "123";
	var B = "123";
	var C = "123";
	var D = "123";
	var E = "123";
	var number= 0;
	
	var msg = {
		"user":"user",
	};

	
	$(document).ready(function(){
		
		$.ajax({
			type:"POST",
			dataType:"POST",
			url:"",
			contentType:"application/json;charset=",
			data:JSON.stringify(msg),
			error:function(XMLHttpRequest,textStatus,errorThrown){
				alert(XMLHttpRequest.status);
			},
			success:function(data){
				for(var i in data){
					var abc = i+"1";
					var bc = i+"2";
					var cd = i+"3";
					
					var one = $("<div></div>");
					$(".u58_1").append(one);
					one.attr("class","u58");
					one.attr("id",data[i].question_id);
					if(msg.question_multiple === "yes"){
						var two = $("<span>"+i+" . "+data[i].question_quest+"  (多选题)</span>");
					}else{
						var two = $("<span>"+i+" . "+data[i].question_quest+"</span>");
					}
					$("#"+abc).append(two);
					two.attr("class","u58_span1");
					

					var three = $("<div></div>");
					$("#"+abc).append(three);
					three.attr("class","u58_ul");
					three.attr("id",bc);

					if(msg.question_multiple === "yes"){
						var four = $("<br><label><input type='checkbox' name='"+data[i].question_id+"' value='1' /><span></span><span style='vertical-align: top;'>"+data[i].question_answer.A+
							"</span></label><br><br><label><input type='checkbox' name='"+data[i].question_id+"' value='2' /><span></span><span style='vertical-align: top;'>"+data[i].question_answer.B+
							"</span></label><br><br><label><input type='checkbox' name='"+data[i].question_id+"' value='3' /><span></span><span style='vertical-align: top;'>"+data[i].question_answer.C+
							"</span></label><br><br><label><input type='checkbox' name='"+data[i].question_id+"' value='4' /><span></span><span style='vertical-align: top;'>"+data[i].question_answer.D+
							"</span></label>")
					}else{
						var four = $("<br><label><input type='radio' name='"+data[i].question_id+"' value='1' /><span></span><span style='vertical-align: top;'>"+data[i].question_answer.A+
							"</span></label><br><br><label><input type='radio' name='"+data[i].question_id+"' value='2' /><span></span><span style='vertical-align: top;'>"+data[i].question_answer.B+
							"</span></label><br><br><label><input type='radio' name='"+data[i].question_id+"' value='3' /><span></span><span style='vertical-align: top;'>"+data[i].question_answer.C+
							"</span></label><br><br><label><input type='radio' name='"+data[i].question_id+"' value='4' /><span></span><span style='vertical-align: top;'>"+data[i].question_answer.D+
							"</span></label>")
					}
					$("#"+bc).append(four);
				}
			},
		});
		/*
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
				var two = $("<span>"+msg[i].question_quest.quest+"  (多选题)</span>");
			}else{
				var two = $("<span>"+msg[i].question_quest.quest+"</span>");
			}
			$("#"+msg[i].question_id).append(two);
			two.attr("class","u58_span1");
			

			var three = $("<div></div>");
			$("#"+msg[i].question_id).append(three);
			three.attr("class","u58_ul");
			three.attr("id",bc);

			if(msg[i].question_multiple === "yes"){
				var four = $("<br><label><input type='checkbox' name='no"+i+"' value='A' /><span></span><span style='vertical-align: top;'>"+msg[i].question_quest.answer.A+
					"</span></label><br><br><label><input type='checkbox' name='no"+i+"' value='B' /><span></span><span style='vertical-align: top;'>"+msg[i].question_quest.answer.B+
					"</span></label><br><br><label><input type='checkbox' name='no"+i+"' value='C' /><span></span><span style='vertical-align: top;'>"+msg[i].question_quest.answer.C+
					"</span></label><br><br><label><input type='checkbox' name='no"+i+"' value='D' /><span></span><span style='vertical-align: top;'>"+msg[i].question_quest.answer.D+
					"</span></label>")
			}else{
				var four = $("<br><label><input type='radio' name='no"+i+"' value='A' /><span></span><span style='vertical-align: top;'>"+msg[i].question_quest.answer.A+
					"</span></label><br><br><label><input type='radio' name='no"+i+"' value='B' /><span></span><span style='vertical-align: top;'>"+msg[i].question_quest.answer.B+
					"</span></label><br><br><label><input type='radio' name='no"+i+"' value='C' /><span></span><span style='vertical-align: top;'>"+msg[i].question_quest.answer.C+
					"</span></label><br><br><label><input type='radio' name='no"+i+"' value='D' /><span></span><span style='vertical-align: top;'>"+msg[i].question_quest.answer.D+
					"</span></label>")
			}
			$("#"+bc).append(four);
		}
		//alert(number);
		
		$("#u58_button").bind("click",submit);
*/






	});

function submit(){
	for(i = 1;i <= number;i++){
		//if($("input[name='no"+i+"']:checkbox").val() == null);
		//console.log($("input[name='no"+i+"']:checked").val());
		//for(j = 0;j < 4;j++){
			//console.log($("input[name='no"+i+"']").eq(j).prop("checked"));
			var val=$('input:radio[name="no'+i+'"]:checked').val();
            	if(val==null){
           	     alert("什么也没选中!");
         	//   }
		}
	}

}


function boxnumber(){  //复选框的个数
	var j = 0;
	for(i = 0;i< $("input").length;i++){
		if($("input").eq(i).attr("type") == "checkbox"){
			j++;

		}
	}
	alert(j);
}