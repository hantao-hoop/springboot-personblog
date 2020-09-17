package com.hantao.service;

import com.hantao.pojo.BlogTags;

import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/17
 * @description:
 */
public interface BlogTagsService {

    int saveBlogTags(BlogTags blogTags);

    int delete(Long id);

    List<Long> selectByBlogId(Long id);
}
