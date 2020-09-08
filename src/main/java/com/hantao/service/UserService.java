package com.hantao.service;

import com.hantao.pojo.User;

/**
 * @author: 蛋蛋
 * @DATE: 2020/8/26
 * @description:
 */
public interface UserService {

    User checkUser(String username, String password);
}
