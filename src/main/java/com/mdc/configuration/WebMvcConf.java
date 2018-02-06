package com.mdc.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@PropertySource("classpath:security.properties")
@PropertySource("classpath:application.properties")
public class WebMvcConf implements WebMvcConfigurer {

    private final Environment env;

    public WebMvcConf(Environment env) {
        this.env = env;
    }

    /**
     * Static resource handler where we store the css or js and images
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler(env.getProperty("resources.handler"))
                .addResourceLocations(env.getProperty("resources.location"))
                .setCachePeriod(0);
    }

    /**
     * Add Hardcoded  views
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(env.getProperty("login.url")).setViewName("login");
        registry.addViewController(env.getProperty("location.access_denied")).setViewName("403");
    }
}
