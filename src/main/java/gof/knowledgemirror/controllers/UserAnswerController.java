package gof.knowledgemirror.controllers;

import gof.knowledgemirror.service.UserAnswerService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/personalTest")
public class UserAnswerController {
    @Autowired
    private UserAnswerService userAnswerService;

    /**
     * 做完题提交 判断得分 并将得分存入record中
     * @param answerJson
     * @return
     */
    @RequestMapping(value= "/submit", method= RequestMethod.POST)
    @ResponseBody   //直接获取返回对象
    public Map<String,Object> getUserAnswer(@RequestBody String answerJson){
        //System.out.println(answerJson);
        return userAnswerService.judgeAnswer(answerJson);
    }


    /**
     * 从数据库中获取结果
     * @param
     * @return
     */
    @RequestMapping(value = "/getScore",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getUserScore(@RequestBody String user){
       return userAnswerService.getScore();
    }
}
