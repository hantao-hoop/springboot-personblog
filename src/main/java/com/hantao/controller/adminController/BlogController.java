package com.hantao.controller.adminController;

import com.github.pagehelper.PageInfo;
import com.hantao.pojo.*;
import com.hantao.pojo.vo.BlogQuery;
import com.hantao.service.BlogService;
import com.hantao.service.BlogTagsService;
import com.hantao.service.Impl.BlogServiceImpl;
import com.hantao.service.Impl.TagServiceImpl;
import com.hantao.service.Impl.TypeServiceImpl;
import com.hantao.service.TagService;
import com.hantao.service.TypeService;
import com.hantao.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/8/27
 * @description:
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    private static  final String INPUT = "admin/blogs-input";
    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogTagsService blogTagsService;

    @GetMapping("/blogs")
    public String blogs(BlogQuery blogQuery,
                        @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                        Model model){

        PageInfo<Blog> pageInfo = blogService.finaAllUserByPage(blogQuery, pageNum, 3);
        model.addAttribute("types", typeService.selectList());
        model.addAttribute("page", pageInfo);
        return LIST;
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

    @GetMapping("/blogs/input")
    public String input(Model model){

        model.addAttribute("types", typeService.selectList());
        model.addAttribute("tags", tagService.selectList());
        model.addAttribute("blog", new Blog());
        return INPUT;
    }

    @Transactional
    @PostMapping("/blogs")
    public String post(
                       @RequestParam Long typeId,
                       Blog blog,
                       RedirectAttributes attributes,
                       HttpSession session){

        BlogTags blogTags = new BlogTags();
        int i;

        if (blog.getId() == null){
            blog.setUser((User) session.getAttribute("user"));
            Type type = typeService.selectById(typeId);
            blog.setType(type);
            List<Tag> tags = tagService.listTag(blog.getTagIds());
            blog.setTags(tags);
            i = blogService.saveBlog(blog);
            Long aNew = blogService.getNew();
            blogTags.setBlogsId(aNew);
            List<Long> list = MyUtils.convertToList(blog.getTagIds());
            for (Long id : list){
                blogTags.setTagsId(id);
                blogTagsService.saveBlogTags(blogTags);
            }
        }else {
            blogTagsService.delete(blog.getId());
            blogTags.setBlogsId(blog.getId());
            i = blogService.updateBlog(blog);
            for (Long id: MyUtils.convertToList(blog.getTagIds())) {
                blogTags.setTagsId(id);
                blogTagsService.saveBlogTags(blogTags);
            }
        }
        //blog.setUser((User) session.getAttribute("user"));
        //System.out.println(tagIds);
        //System.out.println(blog);
        //Type type = typeService.selectById(typeId);
        //blog.setType(type);
        //List<Tag> tags = tagService.listTag(tagIds);
        //blog.setTags(tags);
        //int i = blogService.saveBlog(blog);


        return REDIRECT_LIST;
    }

    private void setTypeAndTag(Long id, Model model){
        //Tag tag = new Tag();
        System.out.println(model.addAttribute("types", typeService.selectList()));
        System.out.println(model.addAttribute("tags", tagService.selectList()));
        //List<Long> blogTags = blogTagsService.selectByBlogId(id);
        //for (Long tid : blogTags){
        //    tag = tagService.selectById(tid);
        //    System.out.println(tag);
        //    model.addAttribute("tags", tag);
        //}

    }

    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id,
                            Model model){
        setTypeAndTag(id, model);
        Blog blog = blogService.selectById(id);
        blog.init();
        //Tag tag = new Tag();
        //Blog blog = new Blog();
        ////BlogTags blogTags = new BlogTags();
        //List<Long> blogTags = blogTagsService.selectByBlogId(id);
        //model.addAttribute("BlogTags", blogTags);
        //System.out.println(blogTags);
        System.out.println(model.addAttribute("blog", blog));
        return INPUT;
    }
}
