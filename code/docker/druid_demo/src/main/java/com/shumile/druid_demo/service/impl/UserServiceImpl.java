package com.shumile.druid_demo.service.impl;

import com.shumile.druid_demo.User;
import com.shumile.druid_demo.UserDao;
import com.shumile.druid_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listData() {
        return userDao.listData();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

}
