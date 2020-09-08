package com.hantao.controller.adminController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hantao.pojo.Tag;
import com.hantao.pojo.Type;
import com.hantao.service.Impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/4
 * @description:
 */

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagServiceImpl tagService;

    //分页查询:pagehelper先查询全部数据，再分页在前端展示
    @GetMapping("/tags")
    public String tag(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum, Model model){

        PageInfo<Tag> page = tagService.finaAllUserByPageS(pageNum, 3);
        PageHelper.clearPage();
        model.addAttribute("page", page);
        PageHelper.clearPage();
        //try {
        //    PageHelper.startPage(pageNum,3);
        //
        //    List<Tag> list = tagService.findAllUserByPage(pageNum, 3);
        //    PageInfo<Tag> page = new PageInfo<>(list);
        //    model.addAttribute("page", page);
        //}finally {
        //    PageHelper.clearPage();
        //}

        return "admin/tags";
    }

    //跳转到新增页面
    @GetMapping("/tags/input")
    public String input(){
        System.out.println("1111");
        return "admin/tags-input";
    }


    //新增标签控制
    @PostMapping("/tags")
    public String insertTag(@RequestParam String name,
                            RedirectAttributes attributes){
        Tag t1 = tagService.selectByName(name);

        if (t1 != null){
            attributes.addFlashAttribute("message", "新增失败，不能添加重复标签");
            return "redirect:/admin/tags/input";
        }else {
            int i = tagService.saveTag(name);
            if (i == 1){
                attributes.addFlashAttribute("message","成功添加"+name+"标签");
            }else {
                attributes.addFlashAttribute("message","添加失败");
            }
            return "redirect:/admin/tags";
        }
    }

    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id,
                            Model model){

        model.addAttribute("tag",tagService.selectById(id));
        return "admin/tags-input";
    }

    //修改编辑
    @PostMapping("/tags/{id}")
    public String editPost(@PathVariable Long id,
                           @RequestParam String name,
                           RedirectAttributes attributes){



        Tag t1 = tagService.selectByName(name);
        //System.out.println(t1);
        //System.out.println(name);
        //System.out.println(id);

        if (t1 != null){
            attributes.addFlashAttribute("message","修改失败，已有该标签！");
            return "redirect:/admin/tags/input";
        }else {
            Tag tag = new Tag();
            tag.setId(id);
            tag.setName(name);
            //Type t = typeService.saveType(name);
            int i = tagService.updateTag(tag);
            if (i == 1){
                attributes.addFlashAttribute("message","修改成功");
            }else {
                attributes.addFlashAttribute("message","修改失败");
            }

            return "redirect:/admin/tags";
        }
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id,
                         RedirectAttributes attributes){

        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/tags";
    }
}
