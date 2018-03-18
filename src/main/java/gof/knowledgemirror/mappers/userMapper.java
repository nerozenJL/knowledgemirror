package gof.knowledgemirror.mappers;

import gof.knowledgemirror.pojos.userEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface userMapper {
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userID", column = "useid"),
            @Result(property = "userName", column = "username")
    })
    List<userEntity> getAll();
}
