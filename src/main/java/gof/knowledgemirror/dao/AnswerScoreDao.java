package gof.knowledgemirror.dao;

import gof.knowledgemirror.pojos.AnswerScoreEntity;
import gof.knowledgemirror.pojos.QuestionEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerScoreDao {

    QuestionEntity selectQuestionAnswerById(int questionId);

    /**
     * 一旦插入成功后  返回主键的值
     * @param answerScoreEntity
     * @return
     */
    int insertUserScoreByUserName(AnswerScoreEntity answerScoreEntity);
}
