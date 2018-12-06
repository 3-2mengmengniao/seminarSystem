package com.test.seminar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆拦截器配置
 *
 * @author zhenweiwang
 * @date 2018/11/24
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {


    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        addInterceptor.addPathPatterns("/**").excludePathPatterns("/login", "/", "/images/**", "/styles/**","/layui/**", "/scripts/**","/forget_password","/new_password");

    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
            HttpSession session = request.getSession();

            //判断是否已有该用户登录的session
            if (session.getAttribute("account") != null) {
                return true;
            }
            //跳转到登录页
            String url = "/";
            response.sendRedirect(url);
            return false;
        }
    }

}
