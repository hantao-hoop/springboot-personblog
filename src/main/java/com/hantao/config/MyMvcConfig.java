package com.hantao.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.hantao.config.LoginHandlerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
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


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns( "/admin", "/admin/login","/css/**", "/img/**", "/js/**");
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

    @Bean
    public PaginationInnerInterceptor PaginationInnerInterceptor(){

        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();

        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInnerInterceptor.setMaxLimit((long) 3);
        //
        //PaginationInnerInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));

        return paginationInnerInterceptor;
    }
}
