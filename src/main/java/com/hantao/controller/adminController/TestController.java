package com.hantao.controller.adminController;

import com.hantao.pojo.Type;
import com.hantao.service.TypeService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: 蛋蛋
 * @DATE: 2020/9/15
 * @description:
 */
@CrossOrigin  //解决跨域问题注解
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TypeService typeService;

    @GetMapping(value = "/type", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Type> test(HttpServletResponse response){
        System.out.println("您请求了");
        return typeService.selectList();
    }
}
