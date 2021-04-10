package com.shumile.druid_demo;

import com.shumile.druid_demo.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTests {

    @SpringBootApplication(scanBasePackages = "com.shumile.druid_demo")
    static class InnerConfig { }

        @Autowired
        private UserService userService;
       //1-对Dao层类或其他外部依赖的类进行Mock
        @MockBean
        private UserDao userDao;

        @Test
        public void testInsert() {
            User user = User.builder().
                    age(11).name("王杰").id(11).build();
            //1.2 执行addUser方法
            userDao.addUser(user);
            //1.3 验证是否执行
            Mockito.verify(userDao).addUser(user);
        }

        @Test
        public void getUserList() {
            User user = User.builder().age(11).name("王杰").id(11).build();
            //1-打桩(准备当前测试场景的前置条件)
            Mockito.when(userDao.listData())
                    .thenReturn(Collections.singletonList(user));
            //2-执行listData方法
            List<User> result = userService.listData();
            //3-对执行结果进行判断
            Assertions.assertThat(result.size()).isEqualTo(1);
            Assertions.assertThat(result.get(0).getName()).isEqualTo("王杰");
        }

}
