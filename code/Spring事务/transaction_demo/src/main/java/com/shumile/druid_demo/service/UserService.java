package com.shumile.druid_demo.service;

import com.shumile.druid_demo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface UserService {
     List<User> listData();
     int addUser(User user);

     void testInvokeBInOneClass();
     void testInvokeBInTwoClass();

     void testNotSupported();

     void testException() throws Exception;

     void throwExceptionTest() throws Exception;

     void throwRuntimeExceptionTest() throws RuntimeException;
}
