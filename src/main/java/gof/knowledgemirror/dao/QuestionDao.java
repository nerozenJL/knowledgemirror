package gof.knowledgemirror.dao;

import gof.knowledgemirror.pojos.AnswerScoreEntity;
import gof.knowledgemirror.pojos.QuestionEntity;
import gof.knowledgemirror.pojos.QuestionLoad;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao {
    /**
     * 根据second_id查询 数据库中的总题目数
     * @param second_id
     * @return
     */
    int queryCountByClass(int second_id);

    /**
     *
     * @return
     */
    int countClass();

    /**
     * 根据随机数取出题目
     * @param startRan
     * @return
     */
    QuestionLoad selectQueByRandom(int second_id,int startRan);


}
