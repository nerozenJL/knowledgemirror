package gof.knowledgemirror.dao;

import gof.knowledgemirror.pojos.AnswerScoreEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordDao {
    AnswerScoreEntity selectRecordByUserName(int times,String user_name);

    int selectTimesByUserName(String user_name);
}

