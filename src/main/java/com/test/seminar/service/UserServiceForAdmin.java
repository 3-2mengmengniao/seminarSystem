package com.test.seminar.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserServiceForAdmin {
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
