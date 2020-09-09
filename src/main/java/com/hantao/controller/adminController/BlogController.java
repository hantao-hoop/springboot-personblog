package com.hantao.controller.adminController;

import com.github.pagehelper.PageInfo;
import com.hantao.pojo.Blog;
import com.hantao.pojo.vo.BlogQuery;
import com.hantao.service.Impl.BlogServiceImpl;
import com.hantao.service.Impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: 蛋蛋
 * @DATE: 2020/8/27
 * @description:
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogService;

    @Autowired
    private TypeServiceImpl typeService;


    @GetMapping("/blogs")
    public String blogs(BlogQuery blogQuery,
                        @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                        Model model){

        PageInfo<Blog> pageInfo = blogService.finaAllUserByPage(blogQuery, pageNum, 3);
        model.addAttribute("types", typeService.selectList());
        model.addAttribute("page", pageInfo);
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(BlogQuery blogQuery,
                        @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                        Model model){

        PageInfo<Blog> pageInfo = blogService.finaAllUserByPage(blogQuery, pageNum, 3);
        //model.addAttribute("types", typeService.selectList());
        model.addAttribute("page", pageInfo);
        return "admin/blogs :: blogList";
    }
}
