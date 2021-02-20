package com.shumile.druid_demo;

import com.shumile.druid_demo.controller.UserController;
import com.shumile.druid_demo.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {
    @SpringBootApplication(scanBasePackages = "com.shumile.druid_demo")
    static class InnerConfig { }
    @Autowired
    private MockMvc mvc;

    //对Service层类或其他外部依赖的类进行Mock
    @MockBean
    private UserService service;

    @Test
    public void getAllUsers() throws Exception {

        User user = User.builder().age(11).name("wangjie").id(11).build();
        //打桩，虚拟返回
        Mockito.when(service.listData()).
                thenReturn(Collections.singletonList(user));
       //预期返回
        mvc.perform(MockMvcRequestBuilders.get("/user/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("wangjie")));
    }
}