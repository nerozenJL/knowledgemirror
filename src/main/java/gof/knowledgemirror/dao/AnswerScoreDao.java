package gof.knowledgemirror.dao;

import gof.knowledgemirror.pojos.AnswerScoreEntity;
import gof.knowledgemirror.pojos.QuestionEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerScoreDao {

    QuestionEntity selectQuestionAnswerById(int questionId);

    int insertUserScoreByUserName(AnswerScoreEntity answerScoreEntity);
}
