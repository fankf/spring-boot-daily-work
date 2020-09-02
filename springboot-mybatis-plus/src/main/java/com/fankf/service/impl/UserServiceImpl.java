package com.fankf.service.impl;

import com.fankf.dao.UserDao;
import com.fankf.entity.User;
import com.fankf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User selectOne(Integer id) {
        return userDao.selectOne(id);
    }
}
