package com.lc.service.Impl;

import com.lc.domain.User;
import com.lc.mapper.UserMapper;
import com.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Date:2019/5/7
 * @Author:lc
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(User user) {
        try {
            userMapper.addUser(user);
            return user;
        } catch (Exception e) {
            throw new RuntimeException("新增用户错误",e);
        }
    }
}
