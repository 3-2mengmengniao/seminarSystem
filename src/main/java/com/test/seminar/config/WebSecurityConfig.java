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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    CustomFailureHandler customFailureHandler;

    @Autowired
    UserServiceImpl userServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/student/**").access("hasRole('STUDENT')")
                .antMatchers("/teacher/**").access("hasRole('TEACHER')" )
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/login")
                .successHandler(customSuccessHandler).failureHandler(customFailureHandler)
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();

                //解决非thymeleaf的form表单提交被拦截问题
                http.csrf().disable();
                http.headers().frameOptions().sameOrigin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl).passwordEncoder(new BCryptPasswordEncoder());;
    }



}