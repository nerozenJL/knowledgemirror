package gof.knowledgemirror.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import gof.knowledgemirror.pojos.UserEntity;
import gof.knowledgemirror.pojos.UserReg;
import gof.knowledgemirror.service.UserService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    private String json;

    @GetMapping("showLogin")
    public String Login() {
        return "login";
    }

    /*@GetMapping("login")  @PathVariable
    public Map<String,UserEntity> login(){

    }*/


    /**
     * 登录
     * @param loginJson
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> doLogin(@RequestBody String loginJson ) {
        ObjectMapper mapper=new ObjectMapper();//转换器
        //ModelAndView mv = new ModelAndView();
        Map<String,Object> modelMap=new HashMap<String, Object>();
        JsonNode rootNode= null;//相当于变成xml形式
        try {
            rootNode = mapper.readTree(loginJson);
            String passWord=rootNode.get("user_password").asText();
            String userName=rootNode.get("user_name").asText();
            if (userService.doLogin(userName,passWord)) {
                //mv.addObject("result", "success");
                //mv.setViewName("redirect:/main");//登录会后重定向到主页
                modelMap.put("result","success");

            }else{
                modelMap.put("result","failure");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.print(modelMap);


        return modelMap;




    }


    /**
     * 注册_检查用户名是否可用
     * @param user_name
     * @return
     */
    @RequestMapping(value="checkUserName",method =RequestMethod.POST )
    //这个注释在控制器为RestController的情况下加不加都一样，
    // 但是如果控制器是Controller类型就必须要加了,它可以把返回的对象直接解析为json对象返回客户端(强！)
    @ResponseBody
    public Map<String, Object> checkUserName(@RequestBody String user_name){


        ObjectMapper mapper=new ObjectMapper();//转换器
        Map<String,Object> modelMap=new HashMap<String,Object>();
        JsonNode rootNode=null;
        try {

            rootNode=mapper.readTree(user_name);//相当于变成xml形式
            String userName=rootNode.get("user_name").asText();//用asText()没有引号  用toString()有引号
            if(!userService.queryByUserName(userName)) {
                modelMap.put("result", "failure");
            }else {

                modelMap.put("result", "success");
            }
            //json=mapper.writeValueAsString(modelMap);将map转换成json对象


        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.print(json);
        return modelMap;

    }


    /**
     * 再将注册信息插入数据库
     * @param user
     * @return
     */
    @RequestMapping(value="doRegister",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> doRegister(@RequestBody UserEntity user){

        Map<String,Object> modelMap=new HashMap<String, Object>();

        int p=userService.addUser(user);
        System.out.print(p);
        if(p!=0){
            modelMap.put("result","success");
        }else{
            modelMap.put("result","failure");
        }

        System.out.print(modelMap);
        return modelMap;


    }


    /**
     * 从数据库中取题
     */




}
