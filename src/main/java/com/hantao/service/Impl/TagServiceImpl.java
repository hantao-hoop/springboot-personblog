package com.hantao.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hantao.mapper.TagMapper;
import com.hantao.pojo.Tag;
import com.hantao.pojo.Type;
import com.hantao.service.TagService;
import com.hantao.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/4
 * @description:
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Transactional
    @Override
    public int saveTag(String name) {
        return tagMapper.insertTag(name);
    }

    @Transactional
    @Override
    public Tag selectById(Long id) {
        return tagMapper.selectById(id);
    }

    @Transactional
    @Override
    public Tag selectByName(String name) {
        return tagMapper.selectByName(name);
    }

    @Transactional
    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagMapper.deleteById(id);
    }

    @Transactional
    @Override
    public List<Tag> selectList() {
        List<Tag> tags = tagMapper.selectAll();
        return tags;
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagMapper.selectWithParams(MyUtils.convertToList(ids));
    }

    //@Transactional
    //@Override
    //public List<Tag> listTag(String ids) {//1,2,3
    //    return tagMapper.selectAll(converToList(ids));
    //}

    //private List<Long> converToList(String ids){
    //    List<Long> list = new ArrayList<>();
    //    if ("".equals(ids) && ids != null){
    //        String[] idarray = ids.split(",");
    //        for (int i = 0; i < idarray.length; i++){
    //            list.add(new Long(idarray[i]));
    //        }
    //    }
    //    return list;
    //}

    @Transactional
    @Override
    public List<Tag> findAllUserByPage(int pageNum, int size) {
        PageHelper.startPage(pageNum,size);
        List<Tag> tags = tagMapper.selectAll();
        return tags ;
    }

    @Transactional
    @Override
    public PageInfo<Tag> finaAllUserByPageS(int pageNum, int size) {

        PageHelper.startPage(pageNum, size);
        List<Tag> tags = tagMapper.selectAll();
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        return pageInfo;
    }
}
