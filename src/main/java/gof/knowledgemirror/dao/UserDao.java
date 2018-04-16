package gof.knowledgemirror.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(UserEntity user);

    UserEntity doLogin(String user_name,String user_password);

    UserEntity queryByUserName(String user_name);
}
