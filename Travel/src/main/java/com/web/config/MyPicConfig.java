package com.web.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyPicConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("===========================================");
        System.out.println("配置文件已生效");
        System.out.println("===========================================");
        registry.addResourceHandler("/img/product/rimage/**").addResourceLocations("file:F:\\X\\IDEA_workspace\\Travel\\src\\main\\resources\\static\\img\\product\\rimage\\");
    }
}
