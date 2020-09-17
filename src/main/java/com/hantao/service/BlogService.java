package com.hantao.service;

import com.github.pagehelper.PageInfo;
import com.hantao.pojo.Blog;
import com.hantao.pojo.Tag;
import com.hantao.pojo.vo.BlogQuery;

import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/5
 * @description:
 */
public interface BlogService {

    //保存博客
    int saveBlog(Blog blog);

    //根据id查询博客
    Blog selectById(Long id);

    //根据类型名查询
    Blog selectByName(String name);

    Long getNew();

    //根据id修改
    int updateBlog(Blog blog);

    //根据id删除类型
    void deleteBlog(Long id);


    PageInfo<Blog> finaAllUserByPage(BlogQuery blog, int pageNum, int size);
}
