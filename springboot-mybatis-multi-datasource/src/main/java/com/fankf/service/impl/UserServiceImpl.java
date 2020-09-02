package com.fankf.service.impl;

import com.fankf.dao.db1.UserDao;
import com.fankf.dao.db2.User2Dao;
import com.fankf.entity.User;
import com.fankf.entity.User2;
import com.fankf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-09-02 10:29:15
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private User2Dao userDao2;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        User user = userDao.queryById(id);
        User2 user2 = userDao2.queryById(id);
        convert(user,user2);
        return user;
    }

    public void convert(User user,User2 user2){
        user.setUsername(user2.getUsername());
        user.setAge(user2.getAge());
    }
}