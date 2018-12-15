package com.test.seminar.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author zhenweiwang
 * @date 2018/11/26
 */

public class Student{
    private BigInteger id;
    private String account;
    private String password;
    private int active;
    private String studentName;
    private String email;
    private int emailReceiveInterval;

    public BigInteger getId() {
        return id;
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmailReceiveInterval() {
        return emailReceiveInterval;
    }

    public void setEmailReceiveInterval(int emailReceiveInterval) {
        this.emailReceiveInterval = emailReceiveInterval;
    }
}
