package com.test.seminar.service;

import com.test.seminar.entity.User;

/**
 * @author zhenweiwang
 * @date 2018/11/26
 */
public interface LoginService {
    User userLogin(String account,String password);
}
