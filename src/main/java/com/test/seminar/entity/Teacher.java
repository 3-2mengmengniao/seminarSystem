package com.test.seminar.entity;

import java.math.BigInteger;

public class Teacher{
    private BigInteger id;
    private String account;
    private String password;
    private int active;
    private String name;
    private String email;
    private int emailReceiveInterval;

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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
