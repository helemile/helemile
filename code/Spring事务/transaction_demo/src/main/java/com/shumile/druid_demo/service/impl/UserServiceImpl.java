package com.shumile.druid_demo.service.impl;

import com.shumile.druid_demo.User;
import com.shumile.druid_demo.UserDao;
import com.shumile.druid_demo.service.TransactionB;
import com.shumile.druid_demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private TransactionB transactionB;

    @Override
    public List<User> listData() {
        return userDao.listData();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    /**
     * 自调用测试：事务失效，表中新增了两条数据：id为10和11的数据
     */
    @Transactional
    @Override
    public void testInvokeBInOneClass(){
        User user = User.builder().id(10).name("王二").age(22).build();
        userDao.addUser(user);
        testB();
    }

    @Transactional
//    public void testB(){
    private void testB(){
        User user = User.builder().id(11).name("张三").age(22).build();
        userDao.addUser(user);
        int i = 1/0;
    }

    /**
     * 自调用测试：事务生效，表中新增了一条数据：id为10的数据
     */
    @Override
    public void testInvokeBInTwoClass(){
        User user = User.builder().id(10).name("王二").age(22).build();
        userDao.addUser(user);
        transactionB.testB();
    }
    @Transactional
    @Override
    public void testNotSupported() {
        User user = User.builder().id(10).name("王二").age(22).build();
        userDao.addUser(user);
        transactionB.testNotSupported();
    }



    /**
     * 7、异常被吃了：try掉异常（未抛出），事务失效
     */
    @Transactional
    @Override
    public void testException() throws Exception {
        try {
            User user = User.builder().id(10).name("王二").age(22).build();
            userDao.addUser(user);
            int i = 1/0;
        }catch (Exception e) {
            System.out.println("执行失败:"+e.getMessage());
            throw new Exception("抛出了Exception异常："+e.getMessage());
//            throw new RuntimeException("执行失败，抛出异常："+e.getMessage());
        }
    }
    /**
     * 8、抛出Exception，而不是RuntimException,事务失效
     */
    @Transactional
    @Override
    public void throwExceptionTest() throws Exception {
        try {
            User user = User.builder().id(10).name("王二").age(22).build();
            userDao.addUser(user);
            int i = 1/0;
        }catch (Exception e) {
            throw new Exception("执行失败，抛出异常："+e.getMessage());
        }
    }
    /**
     * 8.1 、抛出Exception，而不是RuntimException,事务生效
     */
    @Transactional
    @Override
    public void throwRuntimeExceptionTest() throws RuntimeException {
        try {
            User user = User.builder().id(10).name("王二").age(22).build();
            userDao.addUser(user);
            int i = 1/0;
        }catch (Exception e) {
            throw new RuntimeException("执行失败，抛出异常："+e.getMessage());
        }
    }


}
