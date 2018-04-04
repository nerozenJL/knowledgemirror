package gof.knowledgemirror.service;

import gof.knowledgemirror.dao.UserInformationDao;
import gof.knowledgemirror.pojos.UserEntity;
import net.sf.json.JSONObject;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserInformationService {

    @Autowired
    private UserInformationDao userInformationDao;

    //个人信息界面 个人信息显示
    public Map<String,Object> getUserInf(String userName){
        Map<String,Object> modelMap = new HashMap<>();
        JSONObject jo = JSONObject.fromObject(userName);
        UserEntity userEntity= userInformationDao.selectInformationByUserName(jo.getString("user_name"));
        modelMap.put("user_email",userEntity.getUser_email());
        modelMap.put("user_borndate",userEntity.getUser_borndate());
        modelMap.put("user_evalution",userEntity.getUser_evalution());
        modelMap.put("user_education",userEntity.getUser_education());
        modelMap.put("user_experience",userEntity.getUser_experience());
        modelMap.put("user_honor",userEntity.getUser_honor());
        modelMap.put("user_skill",userEntity.getUser_skill());

        return modelMap;
    }

    //修改个人信息
    public Map<String,Object> updateUserInf(UserEntity userEntity){
        userInformationDao.updateInformationByUserName(userEntity);
        Map<String,Object> modelMap = new HashMap<>();

        modelMap.put("result","success");
        return modelMap;
    }

}
