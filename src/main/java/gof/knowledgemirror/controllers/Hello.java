package gof.knowledgemirror.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gof.knowledgemirror.dao.UserDao;
import gof.knowledgemirror.mappers.userMapper;
import gof.knowledgemirror.pojos.Login;
import gof.knowledgemirror.pojos.User;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //标注，第一次使用
public class Hello {

    @RequestMapping("/hello") //同样是标注，作何作用？
    public String sayHello() {
        return "Finally";
    }

//    @Autowired
//    private userMapper um;
//
//    @RequestMapping("getuser")
//    public List<User> dogetUser() {
//        List<User> users=um.getAll();
//        return users;
//    }

    public String name;
    @Autowired
    UserDao userDao;

    //登陆验证
    @RequestMapping(value= "/login", method= RequestMethod.POST)
    @ResponseBody   //直接获取返回对象
    public Map<String,Object> doLogin(@RequestBody String loginJson ) {
        //ObjectMapper mapper=new ObjectMapper();//将java对象转换为json的转换器
        //ModelAndView mv = new ModelAndView();
        Map<String,Object> modelMap=new HashMap<String, Object>();
        JSONObject jO = JSONObject.fromObject(loginJson); //JSONObject方法
//        JsonNode rootNode= null;//相当于变成xml形式   // JsonNode 方法
        try {
//          rootNode = mapper.readTree(loginJson);
//          String passWord=rootNode.get("user_password").asText();
//          String userName=rootNode.get("user_name").asText();
            String passWord=jO.getString("user_password");
            String userName = jO.getString("user_name");
            if (userDao.selectUserByName(userName,passWord) != null) {
                //mv.addObject("result", "success");
                //mv.setViewName("redirect:/main");//登录会后重定向到主页

                modelMap.put("result","success");
                JSONObject j = JSONObject.fromObject(modelMap);
                System.out.print(j);
                modelMap.put("2",j);
                JSONObject r = JSONObject.fromObject(modelMap);
                System.out.print(r);
            }else{
                modelMap.put("result","failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.print(modelMap);
        return modelMap;
    }

    //做完题后得分
    @RequestMapping(value= "/log", method= RequestMethod.POST)
    @ResponseBody   //直接获取返回对象
    public void getAnswer(@RequestBody String answerJson){
        Map<String,Object> modelMap=new HashMap<String, Object>();
        JSONObject ansJson = JSONObject.fromObject(answerJson);

        try {
            String userName = ansJson.getString("user_name");
            for(int i=1 ; i<ansJson.size() ; i++){
                String id = String.valueOf(i);
                String fullAnswer = ansJson.getString(id);
                JSONObject ques = JSONObject.fromObject(fullAnswer);
                String questionId = ques.getString("question_id");
                String answer = ques.getString("question_write_answer");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
