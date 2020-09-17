package com.hantao.mapper;

import com.hantao.pojo.BlogTags;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.security.acl.LastOwnerException;
import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/17
 * @description:
 */
@Mapper
@Repository
public interface BlogTagMapper {

    int insert(BlogTags blogTags);

    @Delete("DELETE FROM blog_tags WHERE blogs_id=#{id}")
    int delete(Long id);

    List<Long> selectByBlogsId(Long id);
}
