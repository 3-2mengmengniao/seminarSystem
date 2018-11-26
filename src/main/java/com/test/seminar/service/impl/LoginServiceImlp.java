package com.test.seminar.service.impl;

import com.test.seminar.dao.LoginDao;
import com.test.seminar.entity.User;
import com.test.seminar.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhenweiwang
 * @date 2018/11/26
 */
@Service
public class LoginServiceImlp implements LoginService{
    @Autowired
    private LoginDao loginDao;

    @Override
    public User userLogin(String account,String password){
        return loginDao.userLogin(account,password);
    }
}
