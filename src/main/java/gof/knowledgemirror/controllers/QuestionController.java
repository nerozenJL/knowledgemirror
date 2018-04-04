package gof.knowledgemirror.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gof.knowledgemirror.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/personalTest")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    private String json;




    @RequestMapping(value="loadQuestion",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getQuestion(){
        return questionService.getQuestionByRandom();
    }






}
