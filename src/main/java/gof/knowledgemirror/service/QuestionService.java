package gof.knowledgemirror.service;

import gof.knowledgemirror.dao.QuestionDao;
//import gof.knowledgemirror.pojos.QuestionEntity;
import gof.knowledgemirror.pojos.QuestionLoad;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import  java.lang.Math;
@Service
public class QuestionService {


    @Autowired
    private QuestionDao questionDao;
    private Integer countTotal;
    //private Integer randomNum;
    private List randomNumList;

    /**
     * 获得随机数
     * @return
     */
    public int getRandomNum(int count){
        return  (int)(Math.random()*count)+1;
        //Random i=new Random();
    }


    /**
     * 判断随机数是否可用
     * 可用就是随机数指之间重复
     * @return
     */
    public boolean judgeAvaRanNum(int randomNum, List<Integer> randomNumList) {
        int judge = 1;
        if (randomNumList.size() == 0) {
            judge = 1;
        }
        for (int i = 0; i < randomNumList.size(); i++) {
            if (randomNum == randomNumList.get(i)) {
                judge = 0;
                break;
            }
        }
        if (judge == 1) return true;
        else return false;

    }


    /**
     * 随机获得各个题目
     * @return
     */

    public Map<String, Object> getQuestionByRandom() {
        int randomNum,i;
        countTotal = 1;
        Map<String, Object> questionMap = new HashMap<String, Object>();//用来存放题目
        randomNumList = new ArrayList();
        //for(int j=1;j<=questionDao.countClass();j++){//三种类型的题
        for (int j = 1; j <= 2; j++) {
            randomNumList.clear();
            for (i = 0; i < 2; i++) {
                /*生成不重复随机数*/
                while (true) {
                    randomNum = getRandomNum(
                            questionDao.queryCountByClass(j));
                    if (judgeAvaRanNum(randomNum, randomNumList)) {
                        randomNumList.add(randomNum);
                        break;
                    }

                }

                System.out.println(randomNum);
                QuestionLoad questionLoad = questionDao.selectQueByRandom(j, randomNum - 1);
                JSONObject answerJson = JSONObject.fromObject(questionLoad.getQuestion_answer());
                questionLoad.setQuestion_answer(answerJson);
                questionMap.put(countTotal.toString(), questionLoad);//将题目放进map
                countTotal++;

            }
        }

        return questionMap;
    }

}
