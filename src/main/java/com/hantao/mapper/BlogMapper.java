package com.hantao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hantao.pojo.Blog;
import com.hantao.pojo.Tag;
import com.hantao.pojo.Type;
import com.hantao.pojo.vo.BlogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/4
 * @description:
 */
@Mapper
@Repository
public interface BlogMapper extends BaseMapper<Blog> {

    int insertBlog(String name);

    Tag selectByName(String name);

    int updateBlog(Blog blog);

    Tag selectById(Long id);

    List<Blog> selectAll();

    List<Blog> selectByTitleAndTypeAndId(@Param("blogQuery") BlogQuery blog);
}
