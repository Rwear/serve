package com.example.demolevel.model.domain.request;

/**
 * ClassName: UserRegisterRequest
 * Package: com.example.demolevel.model.domain.request
 * Description:
 *
 * @Author: 27143
 * @Create: 7/14/2023 6:34 PM
 * @Version: 1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 *用户登录请求
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3903938440912153517L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
