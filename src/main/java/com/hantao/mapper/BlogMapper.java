package com.hantao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hantao.pojo.Blog;
import com.hantao.pojo.Tag;
import com.hantao.pojo.vo.BlogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/4
 * @description:
 */
@Mapper
@Repository
public interface BlogMapper extends BaseMapper<Blog> {

    int saveBlog(Blog blog);

    Blog selectByName(String name);

    int updateBlog(Blog blog);

    Long getNew();

    Blog selectById(Long id);

    List<Blog> selectAll();

    List<Blog> selectByTitleAndTypeAndId(@Param("blogQuery") BlogQuery blog);
}
