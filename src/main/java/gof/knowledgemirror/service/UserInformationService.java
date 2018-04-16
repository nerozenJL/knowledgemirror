package gof.knowledgemirror.service;

import gof.knowledgemirror.dao.UserInformationDao;
import gof.knowledgemirror.pojos.UserEntity;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserInformationService {

    @Autowired
    private UserInformationDao userInformationDao;

    //个人信息界面 个人信息显示
    public Map<String,Object> getUserInf(String userName){
        Map<String,Object> modelMap = new HashMap<String ,Object>();
        JSONObject jo = JSONObject.fromObject(userName);
        UserEntity userEntity= userInformationDao.selectInformationByUserName(jo.getString("user_name"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式化时间
        modelMap.put("user_email",userEntity.getUser_email());
        modelMap.put("user_borndate",sdf.format(userEntity.getUser_borndate()));
        modelMap.put("user_evalution",userEntity.getUser_evalution());
        modelMap.put("user_education",userEntity.getUser_education());
        modelMap.put("user_experience",userEntity.getUser_experience());
        modelMap.put("user_honor",userEntity.getUser_honor());
        modelMap.put("user_skill",userEntity.getUser_skill());

        return modelMap;
    }

    //修改个人信息
    public boolean updateUserInf(UserEntity userEntity){

        if(userInformationDao.updateInformationByUserName(userEntity)>0){
           return true;
        }else {
            return false;
        }
    }

}
