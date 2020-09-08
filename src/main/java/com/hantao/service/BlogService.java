package com.hantao.service;

import com.github.pagehelper.PageInfo;
import com.hantao.pojo.Blog;

import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/5
 * @description:
 */
public interface BlogService {

    //保存博客
    int saveBlog(String name);

    //根据id查询博客
    Blog selectById(Long id);

    //根据类型名查询
    Blog selectByName(String name);


    //根据id修改
    int updateBlog(Blog blog);

    //根据id删除类型
    void deleteBlog(Long id);


    PageInfo<Blog> finaAllUserByPage(int pageNum, int size);
}
