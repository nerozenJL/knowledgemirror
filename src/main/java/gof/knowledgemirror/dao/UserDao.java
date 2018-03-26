package gof.knowledgemirror.dao;

import gof.knowledgemirror.pojos.Login;
import gof.knowledgemirror.pojos.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao
{
    Login selectUserByName(String name,String password);

    User
}