package com.mdc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan({
        "com.mdc.service",
        "com.mdc.security"
})
@PropertySource("classpath:application.properties")
@Configuration
public class JavaConf {
}
