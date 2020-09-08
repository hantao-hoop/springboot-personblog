package com.hantao.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hantao.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/8/29
 * 
 * @description:
 */
@Mapper
@Repository
public interface TypeMapper extends BaseMapper<Type> {

    int insertType(String name);

    Type selectByName(String name);

    int updateType(Type type);

    Type selectById(Long id);

    List<Type> selectAll();
    //IPage<Type> selectPageVo(Page<Type> page, @Param(Constants.WRAPPER) Wrapper<Type> wrapper);
}
