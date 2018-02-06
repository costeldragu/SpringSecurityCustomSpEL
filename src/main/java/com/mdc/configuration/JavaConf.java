package com.mdc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({
        "com.mdc.service",
        "com.mdc.security",
        "com.mdc.repository"
})
@PropertySource("classpath:application.properties")
@Configuration
@EnableJpaRepositories("com.mdc.repository")
public class JavaConf {
}
