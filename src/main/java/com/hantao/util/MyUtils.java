package com.hantao.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/17
 * @description:
 */
public class MyUtils {

    private MyUtils(){}

    public static List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null){
            String[] idarray = ids.split(",");
            for (int i = 0; i < idarray.length; i++){
                list.add(Long.parseLong(idarray[i].trim()));
            }
        }

        return list;
    }

    public static List MyListSort(List list){
        return list;
    }
}
