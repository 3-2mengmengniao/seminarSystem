package com.test.seminar.config;

import com.test.seminar.service.UserServiceForAdmin;
import com.test.seminar.service.impl.UserServiceForAdminImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(1)
public class WebSecurityConfigForAdmin extends WebSecurityConfigurerAdapter {
    private final UserServiceForAdminImpl userServiceForAdminImpl;
    private final CustomSuccessHandler customSuccessHandler;
    private final CustomFailureHandler customFailureHandler;
    private final UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Autowired
    public WebSecurityConfigForAdmin(UserServiceForAdminImpl userServiceForAdminImpl, CustomFailureHandler customFailureHandler, CustomSuccessHandler customSuccessHandler, UnauthorizedEntryPoint unauthorizedEntryPoint) {
        this.userServiceForAdminImpl = userServiceForAdminImpl;
        this.customFailureHandler = customFailureHandler;
        this.customSuccessHandler = customSuccessHandler;
        this.unauthorizedEntryPoint = unauthorizedEntryPoint;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Page Filter
        http.antMatcher("/admin/**")
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN");
        //Admin log config
        http.formLogin()
                .loginPage("/admin/login").loginProcessingUrl("/admin/login")
                .usernameParameter("account").passwordParameter("password")
                .successHandler(customSuccessHandler).failureHandler(customFailureHandler)
                .permitAll();
        http.logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/admin/login");

        //Disable CSRF security
        http.csrf().disable();
        //Enable iframe
        http.headers().frameOptions().sameOrigin();
        //Enable Ajax login fail exception handler
        http.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceForAdminImpl);
    }

}