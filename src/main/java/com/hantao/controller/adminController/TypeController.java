package com.hantao.controller.adminController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hantao.pojo.Type;
import com.hantao.service.Impl.TypeServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/1
 * @description:
 */
@RestController
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeServiceImpl typeService;

    @GetMapping("/types")
    public List<Type> type(Model model,
                       @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum){

        //Page<Type> curPage = new Page<>(1,2);
        //curPage.setCurrent(current);  //当前页面
        //Page<Type> page = typeService.listType(curPage);
        //IPage<Type> page = (Page<Type>) typeService.listType(curPage);
        PageHelper.startPage(pageNum,5);

        List<Type> list = typeService.findAllUserByPage(pageNum,5);
        PageInfo<Type> page = new PageInfo<>(list);
        model.addAttribute("page", page);

        PageHelper.clearPage();

        return typeService.findAllUserByPage(pageNum,5);
    }

    @RequestMapping("/types/input")
    public String input(){

        return "admin/types-input";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id,
                            Model model){
        model.addAttribute("type", typeService.selectById(id));
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String post(@RequestParam String name,
                       RedirectAttributes attributes){

        Type t1 = typeService.selectByName(name);

        if (t1 != null){
            attributes.addFlashAttribute("message","新增失败，已有该类型名！");
            return "redirect:/admin/types/input";
        }else {
            //Type t = typeService.saveType(name);
            int i = typeService.saveType(name);
            if (i == 1){
                attributes.addFlashAttribute("message","新增成功");
            }else {
                attributes.addFlashAttribute("message","新增失败");
            }

            System.out.println(i);

            return "redirect:/admin/types";
        }

    }

    @PostMapping("/types/{id}")
    public String editPost(@PathVariable Long id,
                           @RequestParam String name,
                           RedirectAttributes attributes){



        Type t1 = typeService.selectByName(name);

        if (t1 != null){
            attributes.addFlashAttribute("message","修改失败，已有该类型名！");
            return "redirect:/admin/types/input";
        }else {
            Type type = new Type();
            type.setId(id);
            type.setName(name);
            //Type t = typeService.saveType(name);
            int i = typeService.updateType(type);
            if (i == 1){
                attributes.addFlashAttribute("message","修改成功");
            }else {
                attributes.addFlashAttribute("message","修改失败");
            }

            System.out.println(i);

            return "redirect:/admin/types";
        }


    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }

}
