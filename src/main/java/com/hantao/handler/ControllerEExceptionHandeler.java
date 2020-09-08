package com.hantao.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 蛋蛋
 * @DATE: 2020/8/23
 * @description:
 */
@ControllerAdvice
public class ControllerEExceptionHandeler {

    //获取日志
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHander(HttpServletRequest request, Exception e){

        logger.error("Request URL : {}, Exception : {} ", request.getRequestURL(),e);

        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            try {
                throw e;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", e);
        mv.setViewName("error/error");

        return mv;
    }
}
