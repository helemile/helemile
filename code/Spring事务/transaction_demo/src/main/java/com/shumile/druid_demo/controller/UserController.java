package com.shumile.druid_demo.controller;

import com.shumile.druid_demo.User;
import com.shumile.druid_demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getAllUsers(){
        userService.testInvokeBInOneClass();
        return userService.listData();
    }
    @GetMapping("/add")
    public int addUser(@RequestBody  User user){
        return userService.addUser(user);
    }

    @GetMapping("/testException")
    public void testException() throws Exception {
         userService.testException();
    }

    @GetMapping("/throwExceptionTest")
    public void throwExceptionTest() throws Exception {
         userService.throwExceptionTest();
    }

    @GetMapping("/throwRuntimeException")
    public void throwRuntimeException() throws RuntimeException {
         userService.throwRuntimeExceptionTest();
    }

    @GetMapping("/invokeBInOneClass")
    public void invokeBInOneClass()  {
         userService.testInvokeBInOneClass();
    }
    @GetMapping("/invokeBInTwoClass")
    public void invokeBInTwoClass()  {
         userService.testInvokeBInTwoClass();
    }

    @GetMapping("/testNotSupported")
    public void testNotSupported()  {
         userService.testNotSupported();
    }

    @GetMapping("/testWithoutAnnotation")
    public void testWithoutAnnotation()  {

        TransactionC transactionC = new TransactionC();

        transactionC.testB();
    }


}
