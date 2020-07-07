package cn.tyust.mapper;

import cn.tyust.pojo.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    @Select("select * from t_user where pwd=#{pwd}")
    @Results(id = "userMap", value = {
            @Result(id = true, property = "id", column = "uid")
    })
    User selOneByPwd(@Param("pwd") String pwd);

    @Select("select * from t_user where name=#{name}")
    @ResultMap("userMap")
    User selOneByName(String name);
}
