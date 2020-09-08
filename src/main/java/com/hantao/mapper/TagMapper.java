package com.hantao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hantao.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/4
 * @description:
 */
@Mapper
@Repository
public interface TagMapper extends BaseMapper<Tag> {

    int insertTag(String name);

    Tag selectByName(String name);

    int updateTag(Tag tag);

    Tag selectById(Long id);

    List<Tag> selectAll();
}
