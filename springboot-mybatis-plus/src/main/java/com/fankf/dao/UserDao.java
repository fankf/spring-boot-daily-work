package com.fankf.dao;

import com.fankf.entity.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    User selectOne(int id);
}
