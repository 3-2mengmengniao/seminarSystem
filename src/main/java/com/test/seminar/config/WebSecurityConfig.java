package com.test.seminar.config;

import com.test.seminar.service.UserService;
import com.test.seminar.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    CustomFailureHandler customFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/student/**").access("hasRole('STUDENT')")
                .antMatchers("/teacher/**").access("hasRole('TEACHER')" )
                .and()
                .formLogin().loginPage("/").loginProcessingUrl("/login")
                .successHandler(customSuccessHandler).failureHandler(customFailureHandler)
                .usernameParameter("account").passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();

                //解决非thymeleaf的form表单提交被拦截问题
                http.csrf().disable();
    }

    @Bean
    public UserDetailsService systemUserService() {
        return new UserServiceImpl();
    }

}