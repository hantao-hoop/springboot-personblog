package com.hantao.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hantao.mapper.BlogMapper;
import com.hantao.pojo.Blog;
import com.hantao.pojo.Tag;
import com.hantao.pojo.vo.BlogQuery;
import com.hantao.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/5
 * @description:
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int saveBlog(String name) {
        return 0;
    }

    @Override
    public Blog selectById(Long id) {
        return null;
    }

    @Override
    public Blog selectByName(String name) {
        return null;
    }

    @Override
    public int updateBlog(Blog blog) {
        return 0;
    }

    @Override
    public void deleteBlog(Long id) {

    }

    @Override
    public PageInfo<Blog> finaAllUserByPage(BlogQuery blog, int pageNum, int size) {

        PageHelper.startPage(pageNum,size);
        System.out.println(blog);
        List<Blog> blogs = blogMapper.selectByTitleAndTypeAndId(blog);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return pageInfo;
    }
}
