package com.test.seminar.entity;

import java.math.BigInteger;

/**
 *
 * @author zhenweiwang
 * @date 2018/12/16
 */
public class Admin {
    private BigInteger id;
    private String account;
    private String password;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
