package com.example.demolevel.service;

import com.example.demolevel.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 27143
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2023-07-13 11:12:50
*/
public interface UserService extends IService<User> {

    /**
     * 用户注释
     *
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long UserRegister(String userAccount, String userPassword, String checkPassword);


}
