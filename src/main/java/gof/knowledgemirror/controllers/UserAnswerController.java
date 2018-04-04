package gof.knowledgemirror.controllers;

import gof.knowledgemirror.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserAnswerController {
    @Autowired
    private UserAnswerService userAnswerService;

    //做完题后得分
    @RequestMapping(value= "/submit", method= RequestMethod.POST)
    @ResponseBody   //直接获取返回对象
    public Map<String,Object> getUserAnswer(@RequestBody String answerJson){
        return userAnswerService.getAnswer(answerJson);
    }

    @RequestMapping(value = "/score")
    public Map<String,Object> getUserScore(){
        return userAnswerService.getScore();
    }
}
