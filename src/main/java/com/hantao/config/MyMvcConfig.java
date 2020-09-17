package com.hantao.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.hantao.config.LoginHandlerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: 蛋蛋
 * @DATE: 2020/8/27
 * @description:
 */
@EnableTransactionManagement
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    //解决跨域问题，前后端分离，vue
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("Get", "POST", "HEAD", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns( "/admin", "/admin/login","/css/**", "/img/**", "/js/**", "/test/type");
    }

    //@Override
    //public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //
    //    registry.addResourceHandler("/**").
    //            addResourceLocations("classpath:/static/").
    //            addResourceLocations("classpath:/resources/").
    //            addResourceLocations("classpath:/public/");
    //
    //    (reg
    //}

}
