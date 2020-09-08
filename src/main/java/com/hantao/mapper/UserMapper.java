package com.hantao.mapper;

import com.hantao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: 蛋蛋
 * @DATE: 2020/8/26
 * @description:
 */
@Repository
public interface UserMapper {

    User SelectByNameAndPassword(String username, String password);
}
