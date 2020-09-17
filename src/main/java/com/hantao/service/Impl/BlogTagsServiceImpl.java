package com.hantao.service.Impl;

import com.hantao.mapper.BlogTagMapper;
import com.hantao.pojo.BlogTags;
import com.hantao.service.BlogTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/17
 * @description:
 */
@Service
public class BlogTagsServiceImpl implements BlogTagsService {

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Transactional
    @Override
    public int saveBlogTags(BlogTags blogTags) {
        return blogTagMapper.insert(blogTags);
    }

    @Override
    public int delete(Long id) {
        return blogTagMapper.delete(id);
    }

    @Transactional
    @Override
    public List<Long> selectByBlogId(Long id) {
        return blogTagMapper.selectByBlogsId(id);
    }
}
