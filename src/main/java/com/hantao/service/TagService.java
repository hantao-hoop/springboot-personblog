package com.hantao.service;

import com.github.pagehelper.PageInfo;
import com.hantao.pojo.Tag;

import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/4
 * @description:
 */
public interface TagService {

    //保存标签
    int saveTag(String name);

    //根据id查询类型
    Tag selectById(Long id);

    //根据Tag名查询
    Tag selectByName(String name);


    //根据id修改Tag
    int updateTag(Tag tag);

    //根据id删除Tag
    void deleteTag(Long id);

    List<Tag> findAllUserByPage(int pageNum, int size);

    PageInfo<Tag> finaAllUserByPageS(int pageNum, int size);
}
