package com.hantao.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/7
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogQuery {

    private String title;
    private Long typeid;
    private Boolean recommend;
}
