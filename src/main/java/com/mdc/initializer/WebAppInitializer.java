package com.mdc.initializer;

import com.mdc.configuration.JavaConf;
import com.mdc.configuration.SecurityConf;
import com.mdc.configuration.ThymeleafConfig;
import com.mdc.configuration.WebMvcConf;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Initialize web application Servlet 3.0
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{JavaConf.class, SecurityConf.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConf.class, ThymeleafConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
