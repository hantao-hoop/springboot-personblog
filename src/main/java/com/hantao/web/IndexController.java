package com.hantao.web;

import com.hantao.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 蛋蛋
 * @DATE: 2020/8/23
 * @description:
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        //int i = 9 / 0;
        //String blog = null;
        //if (blog == null){
        //    throw new NotFoundException("博客不存在");
        //}

        System.out.println("index");
        return "index";
    }
}
