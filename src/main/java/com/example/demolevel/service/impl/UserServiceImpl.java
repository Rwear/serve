package com.example.demolevel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demolevel.service.UserService;
import com.example.demolevel.model.domain.User;
import com.example.demolevel.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author 27143
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2023-07-13 11:12:50
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public long UserRegister(String userAccount, String userPassword, String checkPassword) {
        //1.校验

        if(StringUtils.isAnyBlank(userAccount)){
            return -1;
        }
        if(StringUtils.isAnyBlank(userPassword)){
            return -1;
        }
        if(StringUtils.isAnyBlank(checkPassword)){
            return -1;
        }
        if(userAccount.length() < 4){
            return -1;
        }
        if(userPassword.length() < 8 || checkPassword.length() < 8){
            return -1;
        }
        //校验账户不能包含特殊字符
        String validPattern = "^\\w+$";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if(!matcher.matches()){
            return -1;
        }
        //密码和校验密码相同
        if(!userPassword.equals(checkPassword)){
            return -1;
        }
        //账户不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        long count = userMapper.selectCount(queryWrapper);
        if(count > 0)return -1;

        //2.加密
        final String SALT = "level";
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());

        //3.插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        boolean saveResult = this.save(user);
        if(!saveResult)return -1;

        return user.getId();
    }
}




