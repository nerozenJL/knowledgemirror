package gof.knowledgemirror.dao;

import gof.knowledgemirror.pojos.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationDao {
    UserEntity selectInformationByUserName(String userName);

    int updateInformationByUserName(UserEntity userEntity);
}
