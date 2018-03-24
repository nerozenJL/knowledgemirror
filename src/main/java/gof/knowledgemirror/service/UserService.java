package gof.knowledgemirror.service;

import gof.knowledgemirror.dao.UserDao;
import gof.knowledgemirror.pojos.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    public int addUser(UserEntity user){

        return  userDao.insertUser(user);
    }

    public boolean doLogin(String user_name,String user_password){
        //能取到该账号和该密码对应的用户
        if(userDao.doLogin(user_name,user_password)!=null){
            return true;
        }else{
            return false;
        }
    }

    public boolean queryByUserName(String user_name){
        if(userDao.queryByUserName(user_name)!=null){
            return false;//用户存在，该用户名不能使用
        }
        else{
            return true;
        }

    }





}
