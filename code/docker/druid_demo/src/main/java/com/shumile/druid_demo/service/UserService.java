package com.shumile.druid_demo.service;

import com.shumile.druid_demo.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {
     List<User> listData();
     int addUser(User user);
}
