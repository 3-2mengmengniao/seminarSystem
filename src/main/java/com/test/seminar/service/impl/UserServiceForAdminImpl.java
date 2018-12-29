package com.test.seminar.service.impl;

import com.test.seminar.dao.LoginDao;
import com.test.seminar.entity.Admin;
import com.test.seminar.service.UserServiceForAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author xmr
 * @date 2018/11/28
 */

@Service(value = "userServiceForAdminImpl")
public class UserServiceForAdminImpl implements UserServiceForAdmin, UserDetailsService {
    @Autowired
    private LoginDao loginDao;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据用户名从数据库查询对应记录
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Admin admin = loginDao.adminLogin(s);
        if (admin == null) {
            throw new UsernameNotFoundException("username is not exists");
        }
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        String password = passwordEncoder.encode(admin.getPassword());
        org.springframework.security.core.userdetails.User authAdmin = new org.springframework.security.core.userdetails.User(admin.getAccount(), password, list);
        return authAdmin;
    }
}

