package com.test.seminar.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author hatake
 * date 2018/11/30
 */

public interface UserService{
    /**
     * 通过用户名获取用户
     *
     * @param s s
     * @return UserDetails
     * @throws UsernameNotFoundException user name not found
     */
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
