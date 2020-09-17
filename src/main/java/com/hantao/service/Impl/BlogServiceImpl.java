package com.hantao.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hantao.mapper.BlogMapper;
import com.hantao.mapper.BlogTagMapper;
import com.hantao.pojo.Blog;
import com.hantao.pojo.BlogTags;
import com.hantao.pojo.Tag;
import com.hantao.pojo.vo.BlogQuery;
import com.hantao.service.BlogService;
import com.hantao.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Transactional
    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        return blogMapper.saveBlog(blog);
    }

    @Transactional
    @Override
    public Blog selectById(Long id) {
        //List<BlogTags> list = blogTagMapper.selectByBlogsId(id);
        //Blog blog = new Blog();
        //for (BlogTags blogs : list){
        //    blog.setTagIds(blogs.);
        //}
        return blogMapper.selectById(id);
    }

    @Override
    public Blog selectByName(String name) {
        return null;
    }

    @Override
    public Long getNew() {
        return blogMapper.getNew();
    }

    @Override
    public int updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        if ("".equals(blog.getFlag())) {
            blog.setFlag("原创");
        }
        if (!blog.isAppreciation()) {
            blog.setAppreciation(false);
        }
        if (!blog.isCommentabled()) {
            blog.setCommentabled(false);
        }
        if (!blog.isShareStatement()) {
            blog.setShareStatement(false);
        }
        if (!blog.isRecommend()) {
            System.out.println(blog.isRecommend());
            blog.setRecommend(false);
        }
        return blogMapper.updateBlog(blog);
    }

    @Override
    public void deleteBlog(Long id) {

    }

    @Transactional
    @Override
    public PageInfo<Blog> finaAllUserByPage(BlogQuery blog, int pageNum, int size) {

        PageHelper.startPage(pageNum,size);
        List<Blog> blogs = blogMapper.selectByTitleAndTypeAndId(blog);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        return pageInfo;
    }
}
