package gof.knowledgemirror.controllers;

import gof.knowledgemirror.pojos.UserEntity;
import gof.knowledgemirror.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserInformationController {
    @Autowired
    UserInformationService userInformationService;

    @RequestMapping(value = "/infor" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getUserInf(@RequestBody String userInf){
        return userInformationService.getUserInf(userInf);
    }

    @RequestMapping(value = "/up",method = RequestMethod.POST)
    @ResponseBody
    public  Map<String,Object> updateUserInf(@RequestBody UserEntity userEntity){
        System.out.println(userEntity.toString());
       Map<String,Object> modelMap=new HashMap<String, Object>();
        if(userInformationService.updateUserInf(userEntity)==true){
            modelMap.put("result","success");

        }
        return modelMap;
    }
}
