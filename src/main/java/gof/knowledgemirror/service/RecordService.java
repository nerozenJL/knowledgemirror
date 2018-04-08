package gof.knowledgemirror.service;

import gof.knowledgemirror.dao.RecordDao;
import gof.knowledgemirror.pojos.AnswerScoreEntity;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecordService {

    @Autowired
    private RecordDao recordDao;

    //查看用户做题次数
    public Map<String ,Object> getTimes(String timesJson){
        JSONObject times =JSONObject.fromObject(timesJson);
        Map<String ,Object> modelMap = new HashMap<String ,Object>();
        String userName = times.getString("user_name");
        int number = recordDao.selectTimesByUserName(userName);
        modelMap.put("times",number);
        System.out.println(modelMap);
        return modelMap;
    }

    //从数据库获取某条记录信息返回
    public Map<String ,Object> getRecord(String nameJson){
        JSONObject jo =JSONObject.fromObject(nameJson);
        String userName = jo.getString("user_name");
        int times = jo.getInt("id");
        //System.out.println(times);
        Map<String ,Object> modelMap = new HashMap<String ,Object>();
        AnswerScoreEntity answerScore = recordDao.selectRecordByUserName(times-1,userName);
        int amount = 2;
        modelMap.put("html_total",amount);
        modelMap.put("html_right",answerScore.getHtml_score());
        modelMap.put("css_total",amount);
        modelMap.put("css_right",answerScore.getCss_score());
        modelMap.put("ajax_total",amount);
        modelMap.put("ajax_right",answerScore.getAjax_score());
        modelMap.put("js_total",amount);
        modelMap.put("js_right",answerScore.getJs_score());
        modelMap.put("jqury_total",amount);
        modelMap.put("jqury_right",answerScore.getJqury_score());
        int score1 = answerScore.getCom_net_score() + answerScore.getCom_org_score() +
                answerScore.getData_structure_score() + answerScore.getOs_score();
        int score2 = answerScore.getAnalogy_score() + answerScore.getNumber_score() + answerScore.getComprehension_score();
        modelMap.put("pre_base",score1);
        modelMap.put("base",score2);
        modelMap.put("text",answerScore.getText());
        return modelMap;
    }

}
