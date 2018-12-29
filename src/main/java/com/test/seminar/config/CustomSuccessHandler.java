package com.test.seminar.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author xmr
 * @date 2018/11/28
 */

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException{
        PrintWriter writer=response.getWriter();
        writer.write(authentication.getAuthorities().toString());
        writer.close();
        response.setStatus(HttpServletResponse.SC_OK);
    }


}
