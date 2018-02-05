package com.mdc.configuration;

import com.mdc.security.CustomAuthenticationFailureHandler;
import com.mdc.security.CustomAuthenticationSuccessHandler;
import com.mdc.security.CustomLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@PropertySource("classpath:security.properties")
@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

    private final UserDetailsService customUserDetailsService;
    private final Environment env;

    @Autowired
    public SecurityConf(UserDetailsService customUserDetailsService, Environment env) {
        this.customUserDetailsService = customUserDetailsService;
        this.env = env;
    }

    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // This is here to ensure that the static content (JavaScript, CSS, etc)
        // is accessible from the login page without authentication
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(env.getProperty("location.resources")).permitAll()
                .antMatchers(env.getProperty("location.test")).permitAll()
                .antMatchers(env.getProperty("location.login")).access("hasRole('ANONYMOUS')")
                .antMatchers(env.getProperty("location.logout")).access("hasRole('USER')")
                .antMatchers(env.getProperty("location.global")).access("hasRole('USER')")

                .and().exceptionHandling().accessDeniedPage(env.getProperty("location.access_denied"))

                .and().formLogin()
                .loginPage(env.getProperty("login.url"))
                .loginProcessingUrl(env.getProperty("login.processing.url"))
                .failureUrl(env.getProperty("login.failure.url"))
                .usernameParameter(env.getProperty("login.username.parameter"))
                .passwordParameter(env.getProperty("login.password.parameter"))
                .successHandler(customAuthenticationSuccessHandler())
                .failureHandler(customAuthenticationFailureHandler())
                .defaultSuccessUrl(env.getProperty("default.success.url"))

                .and().logout()
                .logoutUrl(env.getProperty("logout.url"))
                .logoutSuccessUrl(env.getProperty("logout.success.url"))
                .logoutSuccessHandler(customLogoutSuccessHandler())
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)

                .and().httpBasic()
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        AuthenticationSuccessHandler customAuthenticationSuccessHandler = new CustomAuthenticationSuccessHandler();
        return customAuthenticationSuccessHandler;
    }

    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
        AuthenticationFailureHandler customAuthenticationFailureHandler = new CustomAuthenticationFailureHandler();
        return customAuthenticationFailureHandler;
    }

    @Bean
    public LogoutSuccessHandler customLogoutSuccessHandler() {
        LogoutSuccessHandler customLogoutSuccessHandler = new CustomLogoutSuccessHandler();
        return customLogoutSuccessHandler;
    }
}
