package com.shumile.druid_demo.service.impl;

import com.shumile.druid_demo.User;
import com.shumile.druid_demo.UserDao;
import com.shumile.druid_demo.service.TransactionB;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class TransactionBImpl implements TransactionB {

    @Resource
    private UserDao userDao;

    @Transactional
    @Override
    public void testB(){
        User user = User.builder().id(11).name("张三").age(22).build();
        userDao.addUser(user);
        int i = 1/0;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public void testNotSupported(){
        User user = User.builder().id(11).name("张三").age(22).build();
        userDao.addUser(user);
        int i = 1/0;
    }
}
