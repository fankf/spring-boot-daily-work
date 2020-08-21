package com.fankf.dao;

import com.fankf.entity.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from user where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "age", property = "age"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "address", property = "address"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
            })
    User selectOne(int id);
}
