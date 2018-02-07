package com.mdc.initializer;

import com.mdc.configuration.JavaConf;
import com.mdc.configuration.JpaConf;
import com.mdc.configuration.SecurityConf;
import com.mdc.configuration.ThymeleafConfig;
import com.mdc.configuration.WebMvcConf;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Initialize web application Servlet 3.0
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Register DispatcherServlet
        super.onStartup(servletContext);

        //Hibernate need this to create innodb tables on system property
        System.setProperty("hibernate.dialect.storage_engine", "innodb");
    }

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{JavaConf.class, JpaConf.class, SecurityConf.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConf.class, ThymeleafConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
