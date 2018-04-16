//sourceMappingURL=echarts.js.map;
/*var msg = {
    "html_total":"3",
    "html_right":"1",
    "css_total":"5",
    "css_right":"2",
    "ajax_total":"6",
    "ajax_right":"4",
    "js_total":"2",
    "js_right":"0",
    "jquery_total":"4",
    "jquery_right":"2",
    "pre_base_total":"23",
    "pre_base_right":"12",
    "base_total":"15",
    "base_right":"4",
    "text":"文件访问假发票我今儿,文件访问假发票我今儿"
};
*/
/*var username = "哈哈哈";
var id = "1";
var msg1 = {
    "id":id,
    "username":username,
};*/
function GetRequest() {//获取url传过来的参数的函数
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
        }
    }
    return theRequest;
};

$(document).ready(function(){
    var Request = new Object();//调用获得url的参数
    Request = GetRequest();
    var id;
    id = Request["id"];
    var username = sessionStorage.getItem("user_name");
    $("#time").append(id);
    //console.log(id);
	var msg1={};
	msg1["id"]=id;
    msg1["user_name"]=username;
    //console.log(JSON.stringify(msg1));

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
    exitbtn.bind("click",exit);

    
    var myChart = echarts.init(document.getElementById('sixStart')); 
    var myPie1 = echarts.init(document.getElementById('pie1')); 
    var myPie2 = echarts.init(document.getElementById('pie2'));
    
    //alert(wid/2-80);
    var aaa = $("#sixStart").width()*1.1/3;
    var bbb = $("#pie1").width()/3;

    $.ajax({
        data:JSON.stringify(msg1),
        dataType:"JSON",
        url:"/record",
        contentType:"application/json;charset=utf-8",
        type:"POST",
        error:function(XMLHttpRequest,textStatus,errorThrown){
            alert(XMLHttpRequest.readyState+":"+XMLHttpRequest.statusText+","+XMLHttpRequest.status);
            return false;
        },
        success:function(msg){
                        var option1 = {
                title : {
                    text:"",
                    x:'center',
                    y:'bottom',
                    padding:[
                        25,0,0,0,
                    ]
                },
                tooltip : {   
                },
                
                calculable : true,
                radar : [
                    {                    
                        indicator : [
                            {text : 'html', max  : msg.html_total,color:'#152935'},
                            {text : 'css', max  : msg.css_total,color:'#152935'},
                            {text : 'ajax', max  : msg.ajax_total,color:'#152935'},
                            {text : 'javascript', max  : msg.js_total,color:'#152935'},
                            {text : 'jquery', max  : msg.jquery_total,color:'#152935'}
                        ],center : ['50%','50%'],
                        radius : aaa, //半径，可放大放小雷达图
                        
                    }
                ],
                series : [
                    {
                        name:'专业分值',
                        type: 'radar',//图表类型 radar为雷达图
                        itemStyle: {
                            normal: {
                                color:"#152935",
                                lineStyle: {
                                    color :"#FFFFFF",
                                    width : 2
                                },
                                areaStyle: {
                                    color:"#152935",
                                    type: 'default',
                                    opacity:'0.5'
                                }
                            }
                        },
                        symbolSize :5,
                        data : [{
                            value:[msg.html_right,msg.css_right,msg.ajax_right,msg.js_right,msg.jquery_right],
                            name:"专业分值"
                        }]
                    }
                ]
            };
            option2 = {
                 title : {
                    text: '专业基础',
                    x:'center',
                    y:'bottom',
                },
                tooltip : {
                    trigger: 'item',
                },
                legend: {
                    orient : 'vertical',
                    x : 'left',
                    data:['专业基础得分','不足']
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        
                        magicType : {
                            type: ['pie', 'funnel'],
                            option: {
                                funnel: {
                                    x: '25%',
                                    width: '50%',
                                    funnelAlign: 'left',
                                    max: bbb
                                }
                            }
                        },
                        
                    }
                },
                calculable : true,
                series : [
                    {
                        name:'专业基础',
                        type:'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:[
                            {value:msg.pre_base_right, name:'专业基础得分'},
                            {value:msg.pre_base_total-msg.pre_base_right,name:'不足'},
                        ],
                        itemStyle: {
                            normal : {
                                label : {
                                  show : false
                                },
                                labelLine : {
                                  show : false
                                }
                              },
                        }
                    }
                ],
                color: ['rgba(21,41,53,0.5)','rgba(21,41,53,0.8)']
            };
            option3 = {
                title : {
                    text: '基础',
                    x:'center',
                    y:'bottom',
                    color:'#152935'
                },
                tooltip : {
                    trigger: 'item',
                },
                legend: {
                    orient : 'vertical',
                    x : 'left',
                    data:['基础得分','不足']
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        
                        magicType : {
                            
                            type: ['pie', 'funnel'],
                            option: {
                                funnel: {
                                    x: '25%',
                                    width: '50%',
                                    funnelAlign: 'left',
                                    max: bbb
                                }
                            }
                        },
                        
                    }
                },
                calculable : true,
                series : [
                    {
                        name:'基础',
                        type:'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:[
                            {value:msg.base_right, name:'基础得分'},
                            {value:msg.base_total-msg.base_right, name:'不足'},
                        ],
                        itemStyle: {
                            normal : {
                                label : {
                                  show : false
                                },
                                labelLine : {
                                  show : true
                                }
                              },
                        }
                    }
                ],
                 color: ['rgba(21,41,53,0.5)','rgba(21,41,53,0.8)']
            };

            $(function(){
                myChart.setOption(option1); 
                myPie1.setOption(option2);
                myPie2.setOption(option3);

            }); 
            var ppp = $("<p>"+msg.text+"</p>");
            $("#result_text").append(ppp);
            ppp.attr("id","ppp");
        }
    })  

    $(window).resize(function(){ 
        window.location.reload();
    });


function usermsg(){
    window.top.location.href="../html/personalpage.html";
};
function exit(){
    top.window.location.replace("login.html");
};
});

