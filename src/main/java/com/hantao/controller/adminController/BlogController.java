package com.hantao.controller.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 蛋蛋
 * @DATE: 2020/8/27
 * @description:
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @GetMapping("/blogs")
    public String blogs(){

        return "admin/blogs";
    }
}
