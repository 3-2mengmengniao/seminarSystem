package com.test.seminar.config;

import com.test.seminar.service.UserService;
import com.test.seminar.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * @author xmr
 * @date 2018/11/28
 */
@Configuration
@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserServiceImpl userServiceImpl;
    private final CustomSuccessHandler customSuccessHandler;
    private final CustomFailureHandler customFailureHandler;
    private final UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Autowired
    public WebSecurityConfig(UserServiceImpl userServiceImpl, CustomFailureHandler customFailureHandler, CustomSuccessHandler customSuccessHandler, UnauthorizedEntryPoint unauthorizedEntryPoint) {
        this.userServiceImpl = userServiceImpl;
        this.customFailureHandler = customFailureHandler;
        this.customSuccessHandler = customSuccessHandler;
        this.unauthorizedEntryPoint = unauthorizedEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Page Filter
        http.authorizeRequests()
                .antMatchers("/student/**").hasRole("STUDENT")
                .antMatchers("/teacher/**").hasRole("TEACHER");
        //User log config
        http.formLogin()
                .loginPage("/login").loginProcessingUrl("/login")
                .usernameParameter("account").passwordParameter("password")
                .successHandler(customSuccessHandler).failureHandler(customFailureHandler)
                .permitAll();
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");

        //Disable CSRF security
        http.csrf().disable();
        //Enable iframe
        http.headers().frameOptions().sameOrigin();
        //Enable Ajax login fail exception handler
        http.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl);
    }

}