package ru.kuper.twodbapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override //Добавление статического содержимого
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/jungle").setViewName("jungle");
    }

}
