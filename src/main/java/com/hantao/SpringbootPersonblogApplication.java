package com.hantao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;

@EntityScan(basePackages = "com.hantao.pojo")
@SpringBootApplication
@MapperScan(value = "com.hantao.mapper")
public class SpringbootPersonblogApplication {

    public static class SpringBeanNameGenerator extends AnnotationBeanNameGenerator {
        @Override
        protected String buildDefaultBeanName(BeanDefinition definition) {
            if (definition instanceof AnnotatedBeanDefinition) {
                String beanName = determineBeanNameFromAnnotation((AnnotatedBeanDefinition) definition);
                if (StringUtils.hasText(beanName)) {
                    // Explicit bean name found.
                    return beanName;
                }
            }
            return definition.getBeanClassName();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPersonblogApplication.class, args);
    }

}
