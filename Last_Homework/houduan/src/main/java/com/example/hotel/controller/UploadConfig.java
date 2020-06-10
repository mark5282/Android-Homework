package com.example.hotel.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class UploadConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//映射图片保存地址
        registry.addResourceHandler("/images/**").addResourceLocations( "file:/Users/guoweili/IdeaProjects/palyerapi/src/main/resources/templates/images/");

    }
}