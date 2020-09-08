package com.hantao.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hantao.NotFoundException;
import com.hantao.mapper.TypeMapper;
import com.hantao.pojo.Type;
import com.hantao.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


/**
 * @author: 蛋蛋
 * @DATE: 2020/8/29
 * @description:
 */
@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeMapper typeMapper;

    @Transactional
    @Override
    public int saveType(String  name) {
        System.out.println(name);
        int i = typeMapper.insertType(name);
        return i;
    }

    @Transactional
    @Override
    public Type selectById(Long id) {
        return typeMapper.selectById(id);
    }

    @Override
    public List<Type> selectList() {
        return typeMapper.selectAll();
    }


    @Transactional
    @Override
    public Type selectByName(String name) {
        return typeMapper.selectByName(name);
    }


    //@Transactional
    //@Override
    //public IPage<Type> listType(Page<Type> page) {
    //    return typeMapper.selectPageVo(page,);
    //}


    @Transactional
    @Override
    public int updateType(Type type) {

        System.out.println(type.getName());
        System.out.println(type.getId());
        return typeMapper.updateType(type);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeMapper.deleteById(id);
    }

    @Transactional
    @Override
    public List<Type> findAllUserByPage(int pageNum, int size) {

        PageHelper.startPage(pageNum,size);
        List<Type> types = typeMapper.selectAll();
        return types ;
    }

    @Transactional
    @Override
    public PageInfo<Type> finaAllUserByPageS(int pageNum, int size) {

        PageHelper.startPage(pageNum,size);
        List<Type> types = typeMapper.selectList(null);
        PageInfo<Type> pageInfo = new PageInfo<>(types);
        return pageInfo;
    }


}
