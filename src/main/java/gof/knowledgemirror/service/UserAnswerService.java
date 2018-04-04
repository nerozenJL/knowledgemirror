package gof.knowledgemirror.service;

import gof.knowledgemirror.dao.AnswerScoreDao;
import gof.knowledgemirror.dao.QuestionDao;
import gof.knowledgemirror.pojos.AnswerScoreEntity;
import gof.knowledgemirror.pojos.QuestionEntity;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserAnswerService {
    private int score1 =0;
    private int score2 =0;
    private int score3 =0;
    private int score4 =0;
    private int score5 =0;
    private int score6 =0;
    private int score7 =0;
    private int score8 =0;
    private int score9 =0;
    private int score10 =0;
    private int score11 =0;
    private int score12 =0;
    private int score13 =0;
    private int score14 =0;
    private String evaluate="";

    @Autowired
    private AnswerScoreDao answerScoreDao;

    public Map<String,Object> getAnswer(String answerJson){
        Map<String,Object> modelMap=new HashMap<String, Object>();
        JSONObject ansJson = JSONObject.fromObject(answerJson);

        String userName = ansJson.getString("user_name");
        for(int i=1 ; i<ansJson.size()-1 ; i++){
            String id = String.valueOf(i);//第几道题
            String fullAnswer = ansJson.getString(id);
            JSONObject ques = JSONObject.fromObject(fullAnswer);
            int questionId = ques.getInt("question_id");
            String answer = ques.getString("question_write_answer");
            QuestionEntity question = answerScoreDao.selectQuestionAnswerById(questionId); //通过题目id查询题目答案和类别
            String right = question.getQuestion_right_answer().toUpperCase();
            if (answer.equals(right)){
                if(question.getSecond_id()==1){
                    score1 = score1+1;
                    }else if(question.getSecond_id()==2){
                        score2 = score2 +1;
                    }else if(question.getSecond_id()==3){
                        score3 = score3 +1;
                    }else if(question.getSecond_id()==4){
                        score4 = score4+1;
                    }else if(question.getSecond_id()==5){
                        score5 = score5+1;
                    }else if(question.getSecond_id()==6){
                        score6 = score6+1;
                    }else if(question.getSecond_id()==7){
                        score7 = score7+1;
                    }else if(question.getSecond_id()==8){
                        score8 = score8+1;
                    }else if(question.getSecond_id()==9){
                        score9 = score9+1;
                    }else if(question.getSecond_id()==10){
                        score10 = score10+1;
                    }else if(question.getSecond_id()==11){
                        score11 = score11+1;
                    }else if(question.getSecond_id()==12){
                        score12 = score12+1;
                    }
                }
            }



        AnswerScoreEntity answerScoreEntity = new AnswerScoreEntity();
        answerScoreEntity.setUser_name(userName);
        answerScoreEntity.setHtml_score(score1);//将得分写入实体类
        answerScoreEntity.setCss_score(score2);
        answerScoreEntity.setAjax_score(score3);
        answerScoreEntity.setJs_score(score4);
        answerScoreEntity.setJqury_score(score5);
        answerScoreEntity.setData_structure_score(score6);
        answerScoreEntity.setOs_score(score7);
        answerScoreEntity.setCom_net_score(score8);
        answerScoreEntity.setCom_org_score(score9);
        answerScoreEntity.setComprehension_score(score10);
        answerScoreEntity.setAnalogy_score(score11);
        answerScoreEntity.setNumber_score(score12);
        answerScoreEntity.setText(evaluate);

        answerScoreDao.insertUserScoreByUserName(answerScoreEntity);

        modelMap.put("result","success"); //返回前端的成功
        return modelMap;
    }

    public Map<String,Object> getScore(){
        int amount = 2;
        int pre_base = 8;
        int base = 6;
        Map<String,Object> modelMap=new HashMap<String, Object>();
        modelMap.put("html_total",amount);
        modelMap.put("html_right",score1);
        modelMap.put("css_total",amount);
        modelMap.put("css_right",score2);
        modelMap.put("ajax_total",amount);
        modelMap.put("ajax_right",score3);
        modelMap.put("js_total",amount);
        modelMap.put("js_right",score4);
        modelMap.put("jqury_total",amount);
        modelMap.put("jqury_right",score5);
        score13 = score6 + score7 + score8 + score9;
        score14 = score10 + score11 + score12;
        modelMap.put("pre_base_total",pre_base);
        modelMap.put("pre_base_right",score13);
        modelMap.put("base_total",base);
        modelMap.put("base",score14);
        modelMap.put("text",evaluate);


        return modelMap;
    }


}
