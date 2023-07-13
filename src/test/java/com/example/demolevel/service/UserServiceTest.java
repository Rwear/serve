package com.example.demolevel.service;


import com.example.demolevel.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * ClassName: UserServiceTest
 * Package: com.example.demolevel.service
 * Description:
 *
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void testAddUser(){
        User user = new User();
        user.setUsername("dog");
        user.setUserAccount("abc");
        user.setAvatarUrl("https://leetcode.com/_next/static/images/logo-ff2b712834cf26bf50a5de58ee27bcef.png");
        user.setGender(0);
        user.setUserPassword("123");
        user.setPhone("456");
        user.setEmail("789");

        boolean res = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(res);


    }

    @Test
    void userRegister() {
        String userAccount = "level";
        String userPassword = "";
        String checkPassword = "123456";
        long result = userService.UserRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "lev";
        result = userService.UserRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "level";
        userPassword = "123456";
        result = userService.UserRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "lev el";
        userPassword = "12345678";
        result = userService.UserRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        checkPassword = "123456789";
        result = userService.UserRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "dog";
        checkPassword = "12345678";
        result = userService.UserRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "level";
        result = userService.UserRegister(userAccount, userPassword, checkPassword);
        Assertions.assertTrue(result > 0);




    }
}