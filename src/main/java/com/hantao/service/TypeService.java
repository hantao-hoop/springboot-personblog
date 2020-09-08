package com.hantao.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.hantao.pojo.Type;
import com.hantao.pojo.User;

import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/8/29
 * @description:
 */
public interface TypeService{

    //保存标签
    int saveType(String name);

    //根据id查询类型
    Type selectById(Long id);

    //根据类型名查询
    Type selectByName(String name);

    //spring自带的分页功能
    //IPage<Type> listType(Page<Type> page);

    //根据id修改类型
    int updateType(Type type);

    //根据id删除类型
    void deleteType(Long id);

    List<Type> findAllUserByPage(int pageNum, int size);

    PageInfo<Type> finaAllUserByPageS(int pageNum, int size);

}
