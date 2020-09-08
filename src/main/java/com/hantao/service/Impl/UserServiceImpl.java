package com.hantao.service.Impl;

import com.hantao.mapper.UserMapper;
import com.hantao.pojo.User;
import com.hantao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: 蛋蛋
 * @DATE: 2020/8/26
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public User checkUser(String username, String password) {
        User user = userMapper.SelectByNameAndPassword(username, password);
        return user;
    }
}
