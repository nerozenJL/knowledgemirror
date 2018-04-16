package gof.knowledgemirror.controllers;

import gof.knowledgemirror.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class RecordController {
    @Autowired
    private RecordService recordService;

    //根据用户名获取所做题目的次数
    @RequestMapping(value = "/times",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getTimes(@RequestBody String timesJson){
        return recordService.getTimes(timesJson);
    }

    //用户所做题目记录
    @RequestMapping(value = "/record",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getRecord(@RequestBody String nameJson){

        return recordService.getRecord(nameJson);
    }
}
